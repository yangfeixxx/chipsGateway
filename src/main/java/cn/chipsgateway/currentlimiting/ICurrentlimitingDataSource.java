package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.Entity.RequestRecordEntity;

public interface ICurrentlimitingDataSource {
    RequestRecordEntity getRequestRecordEntity(String requestRecordId);

    void addRequestRecordCount(String requestRecordId);

    void resetRequestRecordCount(String requestRecordId);
}
