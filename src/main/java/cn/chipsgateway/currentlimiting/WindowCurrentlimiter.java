package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.Entity.RequestRecordEntity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WindowCurrentlimiter extends AbstractCurrentlimiter {
    private static final Lock lock = new ReentrantLock(true);

    @Override
    Boolean runCurrentLimiting(String requestRecordId) {
        long allocateCount = currentlimiterConfig.getAllocateCount();
        long allocateTime = currentlimiterConfig.getAllocateTime();
        lock.lock();
        //我这里加锁的原因是因为在不能保证操作原子性的情况下,使用Atomic类也不能保证数据一致性
        try {
            long currentTimeMillis = System.currentTimeMillis();
            RequestRecordEntity requestRecordEntity = iCurrentlimitingDataSource.getRequestRecordEntity(requestRecordId);
            long lastRecordTime = requestRecordEntity.getLastAccessTimeMS();
            long count = requestRecordEntity.getCount();
            if (currentTimeMillis - lastRecordTime <= allocateTime) {
                if (count >= allocateCount)
                    return false;
                requestRecordEntity.addCount();
            } else {
                requestRecordEntity.setLastAccessTimeMS(lastRecordTime);
                requestRecordEntity.resetCount();
            }
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    void setiCurrentlimitingDataSource(ICurrentlimitingDataSource iCurrentlimitingDataSource) {
        super.iCurrentlimitingDataSource = iCurrentlimitingDataSource;
    }

    @Override
    void setCurrentlimiterConfig(CurrentlimiterConfig currentlimiterConfig) {
        super.currentlimiterConfig = new CurrentlimiterConfig();
    }
}
