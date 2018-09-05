package cn.chipsgateway.currentlimiting;

public class CurrentlimiterConfig {
    private long allocateTime = 1000L;
    private long allocateCount = 100L;
    private long lastRecordTime;

    public long getLastRecordTime() {
        return lastRecordTime;
    }

    public void setLastRecordTime(long lastRecordTime) {
        this.lastRecordTime = lastRecordTime;
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
