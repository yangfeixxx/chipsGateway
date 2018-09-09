package cn.chipsgateway.preFilter;

import cn.chipsgateway.Entity.RequestRecordEntity;
import cn.chipsgateway.filter.AbstractChipsGatewayFilter;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;
import cn.chipsgateway.utils.WebHelpUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultOpposeReptileFilter extends AbstractChipsGatewayFilter {
    private long currentlimitingCount = 60L;

    private long currentLimitingTimeMS = 1000L;

    public long getCurrentlimitingCount() {
        return currentlimitingCount;
    }

    public void setCurrentlimitingCount(long currentlimitingCount) {
        this.currentlimitingCount = currentlimitingCount;
    }

    public long getCurrentLimitingTimeMS() {
        return currentLimitingTimeMS;
    }

    public void setCurrentLimitingTimeMS(long currentLimitingTimeMS) {
        this.currentLimitingTimeMS = currentLimitingTimeMS;
    }

    private static final Map<String, RequestRecordEntity> map = new ConcurrentHashMap();

    public RequestRecordEntity getRequestRecord(String requestRecordId) {
        return map.get(requestRecordId);
    }

    public void setRequestRecord(String requestRecordId, RequestRecordEntity requestRecordEntity) {
        map.put(requestRecordId, requestRecordEntity);
    }

    public boolean shouldFilter() {
        return false;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public boolean run(GatewayHttpServletRequest request, GatewayHttpServletResponse response) {

        RequestRecordEntity requestRecord = getRequestRecord(WebHelpUtils.getRequestUrl(request) + WebHelpUtils.getIpAddress(request));
        Long count = requestRecord.getCount();
        long lastAccessTimeMS = requestRecord.getLastAccessTimeMS().longValue();
        long currentTimeMS = System.currentTimeMillis();

        if (lastAccessTimeMS - currentTimeMS <= currentLimitingTimeMS) {
            if (count >= currentlimitingCount) {
                return false;
            }
        } else {
            requestRecord.setLastAccessTimeMS(currentTimeMS);
            requestRecord.setCount(0L);
        }
        return true;
    }

}
