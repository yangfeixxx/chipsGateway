package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.entity.RequestRecordEntity;

public interface ICurrentlimitingDataSource {
    RequestRecordEntity getRequestRecordEntity(String requestRecordId);

    void setRequestRecordEntity(String requestRecordId, RequestRecordEntity requestRecordEntity);

    void addRequestRecordCount(String requestRecordId);

    void resetRequestRecordCount(String requestRecordId);
}
