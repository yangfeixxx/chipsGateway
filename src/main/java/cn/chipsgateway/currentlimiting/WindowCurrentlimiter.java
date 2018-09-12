package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.entity.RequestRecordEntity;
import cn.chipsgateway.context.RequestContext;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WindowCurrentlimiter extends AbstractCurrentlimiter {
    private static final Lock LOCK = new ReentrantLock(true);

    @Override
    public Boolean runCurrentLimiting(CurrentlimiterConfig currentlimiterConfig) {
        long allocateCount = currentlimiterConfig.getAllocateCount();
        long allocateTime = currentlimiterConfig.getAllocateTime();
        RequestContext currentRequest = RequestContext.getCurrentRequest();
        LOCK.lock();
        //我这里加锁的原因是因为在不能保证操作原子性的情况下,使用Atomic类也不能保证数据一致性
        try {
            long currentTimeMillis = System.currentTimeMillis();
            RequestRecordEntity requestRecordEntity = icds.getRequestRecordEntity(currentlimiterConfig.getUrl());
            if (requestRecordEntity == null) {
                icds.setRequestRecordEntity(currentlimiterConfig.getUrl(), new RequestRecordEntity(currentlimiterConfig.getUrl(), 0L, System.currentTimeMillis()));
                return true;
            }
            long lastRecordTime = requestRecordEntity.getLastAccessTimeMS();
            long count = requestRecordEntity.getCount();
            if (currentTimeMillis - lastRecordTime <= allocateTime) {
                if (count >= allocateCount) {
                    currentRequest.setFailedFilterIpVisitUrlErrorMessage();
                    currentRequest.setFailedFilterType("WindowCurrentlimiter");
                    return false;
                }
                requestRecordEntity.addCount();
            } else {
                requestRecordEntity.setLastAccessTimeMS(lastRecordTime);
                requestRecordEntity.resetCount();
            }
        } finally {
            LOCK.unlock();
        }
        return true;
    }


}
