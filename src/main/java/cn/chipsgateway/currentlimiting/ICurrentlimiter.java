package cn.chipsgateway.currentlimiting;

public interface ICurrentlimiter {
      Boolean runCurrentLimiting(CurrentlimiterConfig CurrentlimiterConfig);

      void setiCurrentlimitingDataSource(ICurrentlimitingDataSource iCurrentlimitingDataSource);

}
