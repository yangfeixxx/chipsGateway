package cn.chipsgateway.currentlimiting;

public class CurrentlimiterConfig {
    private String url;
    private long allocateTime = 1000L;
    private long allocateCount = 100L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getAllocateTime() {
        return allocateTime;
    }

    public void setAllocateTime(long allocateTime) {
        this.allocateTime = allocateTime;
    }

    public long getAllocateCount() {
        return allocateCount;
    }

    public void setAllocateCount(long allocateCount) {
        this.allocateCount = allocateCount;
    }
}
