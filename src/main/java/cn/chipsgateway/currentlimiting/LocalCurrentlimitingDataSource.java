package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.entity.RequestRecordEntity;

import java.util.HashMap;
import java.util.Map;

public class LocalCurrentlimitingDataSource extends CurrentlimitingDataSourceWraper {
    private Map<String, RequestRecordEntity> map = new HashMap();

    @Override
    public RequestRecordEntity getRequestRecordEntity(String requestRecordId) {
        return map.get(requestRecordId);
    }

    @Override
    public void addRequestRecordCount(String requestRecordId) {
        map.get(requestRecordId).addCount();
    }

    @Override
    public void resetRequestRecordCount(String requestRecordId) {
        map.get(requestRecordId).resetCount();
    }
    @Override
    public void setRequestRecordEntity(String requestRecordId, RequestRecordEntity requestRecordEntity) {
        map.put(requestRecordId,requestRecordEntity);
    }
}
