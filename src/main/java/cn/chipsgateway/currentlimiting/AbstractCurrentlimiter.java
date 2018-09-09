package cn.chipsgateway.currentlimiting;

public abstract class AbstractCurrentlimiter {

    protected ICurrentlimitingDataSource iCurrentlimitingDataSource;

    public abstract Boolean runCurrentLimiting(CurrentlimiterConfig CurrentlimiterConfig);

    public abstract void setiCurrentlimitingDataSource(ICurrentlimitingDataSource iCurrentlimitingDataSource);


}
