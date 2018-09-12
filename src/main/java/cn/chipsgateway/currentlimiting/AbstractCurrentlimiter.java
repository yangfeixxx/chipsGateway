package cn.chipsgateway.currentlimiting;

public abstract class AbstractCurrentlimiter implements ICurrentlimiter {

    protected ICurrentlimitingDataSource icds;

    @Override
    public void setiCurrentlimitingDataSource(ICurrentlimitingDataSource iCurrentlimitingDataSource) {
        this.icds = iCurrentlimitingDataSource;
    }


}
