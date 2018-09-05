package cn.chipsgateway.Entity;

import java.time.LocalDateTime;

public class RequestRecordEntity {
    private String ip;
    private String url;
    private Long count;
    private Long LastAccessTimeMS;

    public RequestRecordEntity(String ip, String url, Long count, Long lastAccessTimeMS) {
        this.ip = ip;
        this.url = url;
        this.count = count;
        LastAccessTimeMS = lastAccessTimeMS;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
