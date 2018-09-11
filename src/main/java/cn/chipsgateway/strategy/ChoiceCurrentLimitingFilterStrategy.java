package cn.chipsgateway.strategy;

import cn.chipsgateway.context.RequestContext;
import cn.chipsgateway.currentlimiting.AbstractCurrentlimiter;
import cn.chipsgateway.currentlimiting.CurrentlimiterConfig;

import java.util.Map;

//限流策略有很多种,使用此类将限流具体实现由用户进行选择,只要注入abstractCurrentlimiter的是什么限流器,那用的就是什么限流器
public class ChoiceCurrentLimitingFilterStrategy implements ChoiceStrategy<Boolean> {
    private final Map<String, CurrentlimiterConfig> urlMatchingCurrentlimiterConfig;
    private final AbstractCurrentlimiter abstractCurrentlimiter;

    public ChoiceCurrentLimitingFilterStrategy(Map map, AbstractCurrentlimiter abstractCurrentlimiter) {
        urlMatchingCurrentlimiterConfig = map;
        this.abstractCurrentlimiter = abstractCurrentlimiter;
    }

    @Override
    public Boolean choice() {
        return abstractCurrentlimiter.runCurrentLimiting(urlMatchingCurrentlimiterConfig.get(RequestContext.getCurrentRequest().getRequestUrl()));
    }
}
