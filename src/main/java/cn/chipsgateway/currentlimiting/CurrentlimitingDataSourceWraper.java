package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.Entity.RequestRecordEntity;

public class CurrentlimitingDataSourceWraper implements ICurrentlimitingDataSource {

    @Override
    public long getCount() {
        throw new RuntimeException("不能直接使用包装类");
    }

    @Override
    public void addCount() {
        throw new RuntimeException("不能直接使用包装类");
    }

    @Override
    public void resetCount() {
        throw new RuntimeException("不能直接使用包装类");
    }
}
