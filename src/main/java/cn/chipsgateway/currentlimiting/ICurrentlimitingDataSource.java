package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.Entity.RequestRecordEntity;

import java.util.List;

public interface ICurrentlimitingDataSource {
    long getCount();

    void addCount();


    void resetCount();
}
