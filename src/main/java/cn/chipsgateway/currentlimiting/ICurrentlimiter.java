package cn.chipsgateway.currentlimiting;

public interface ICurrentlimiter {
    public  Boolean runCurrentLimiting(CurrentlimiterConfig CurrentlimiterConfig);

    public  void setiCurrentlimitingDataSource(ICurrentlimitingDataSource iCurrentlimitingDataSource);

}
