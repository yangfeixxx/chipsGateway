package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.Entity.RequestRecordEntity;

public class CurrentlimitingDataSourceWraper implements ICurrentlimitingDataSource {

    @Override
    public RequestRecordEntity getRequestRecordEntity(String requestRecordId) {
        throw new RuntimeException("不能直接使用包装类");
    }

    @Override
    public void addRequestRecordCount(String requestRecordId) {
        throw new RuntimeException("不能直接使用包装类");
    }

    @Override
    public void resetRequestRecordCount(String requestRecordId) {
        throw new RuntimeException("不能直接使用包装类");
    }
}
