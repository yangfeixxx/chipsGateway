package cn.chipsgateway.currentlimiting;

import cn.chipsgateway.Entity.RequestRecordEntity;
import cn.chipsgateway.strategy.ChoiceStrategy;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalCurrentlimitingDataSource extends CurrentlimitingDataSourceWraper {

    private long count = 0L;

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void addCount() {
        ++count;
    }

    @Override
    public void resetCount() {
        count = 0L;
    }
}
