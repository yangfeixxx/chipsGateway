package cn.chipsgateway.preFilter;

import cn.chipsgateway.entity.RequestRecordEntity;
import cn.chipsgateway.filter.AbstractChipsGatewayFilter;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;
import cn.chipsgateway.utils.WebHelpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cn.chipsgateway.support.GatewayConstant.PREFILTER;

//如果网关不直接对前端开放,请不要开启(默认关闭)
public class DefaultOpposeReptileFilter extends AbstractChipsGatewayFilter {
    private long currentlimitingCount = 60L;

    private long currentLimitingTimeMS = 1000L;

    public long getCurrentlimitingCount() {
        return currentlimitingCount;
    }

    public void setCurrentlimitingCount(long currentlimitingCount) {
        this.currentlimitingCount = currentlimitingCount;
    }

    public long getCurrentLimitingTimeMS() {
        return currentLimitingTimeMS;
    }

    public void setCurrentLimitingTimeMS(long currentLimitingTimeMS) {
        this.currentLimitingTimeMS = currentLimitingTimeMS;
    }

    private static final Map<String, RequestRecordEntity> MAP = new ConcurrentHashMap();

    private static final String REPTILEUG = "FeedDemon,JikeSpider,Indy Library,Alexa Toolbar,AskTbFXTV,AhrefsBot,CrawlDaddy,CoolpadWebkit,Java,Feedly,UniversalFeedParser,ApacheBench,Microsoft URL Control,Swiftbot,ZmEu,oBot,jaunty,Python-urllib,lightDeckReports Bot,YYSpider,DigExt,YisouSpider,HttpClient,MJ12bot,heritrix,EasouSpider,Ezooms";


    public RequestRecordEntity getRequestRecord(String requestRecordId) {
        return MAP.get(requestRecordId);
    }

    public void setRequestRecord(String requestRecordId, RequestRecordEntity requestRecordEntity) {
        MAP.put(requestRecordId, requestRecordEntity);
    }


    public boolean shouldFilter() {
        return false;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return PREFILTER;
    }

    @Override
    public boolean run(GatewayHttpServletRequest request, GatewayHttpServletResponse response) {
        String userAgent = WebHelpUtils.getUserAgent(request);

        if (userAgent == null || REPTILEUG.contains(userAgent)) {
            return false;
        }

        String requestRecordId = WebHelpUtils.getRequestUrl(request) + WebHelpUtils.getIpAddress(request);
        RequestRecordEntity requestRecord = getRequestRecord(requestRecordId);
        if (requestRecord == null) {
            setRequestRecord(requestRecordId, new RequestRecordEntity(requestRecordId, 0L, System.currentTimeMillis()));
            return true;
        }
        Long count = requestRecord.getCount();
        long lastAccessTimeMS = requestRecord.getLastAccessTimeMS().longValue();
        long currentTimeMS = System.currentTimeMillis();

        if (lastAccessTimeMS - currentTimeMS <= currentLimitingTimeMS) {
            if (count >= currentlimitingCount) {
                return false;
            }
        } else {
            requestRecord.setLastAccessTimeMS(currentTimeMS);
            requestRecord.setCount(0L);
        }
        return true;
    }

}
