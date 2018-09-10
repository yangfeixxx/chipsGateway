package cn.chipsgateway.entity;

public class RequestRecordEntity {
    private String id;
    private Long count;
    private Long LastAccessTimeMS;

    public RequestRecordEntity(String id, Long count, Long lastAccessTimeMS) {
        this.id = id;
        this.count = count;
        LastAccessTimeMS = lastAccessTimeMS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addCount() {
        ++count;
    }

    public void resetCount() {
        count = 0L;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getLastAccessTimeMS() {
        return LastAccessTimeMS;
    }

    public void setLastAccessTimeMS(Long lastAccessTimeMS) {
        LastAccessTimeMS = lastAccessTimeMS;
    }
}
