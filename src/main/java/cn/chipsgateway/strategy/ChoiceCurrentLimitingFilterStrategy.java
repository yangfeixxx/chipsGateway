package cn.chipsgateway.strategy;

import cn.chipsgateway.context.RequestContext;
import cn.chipsgateway.currentlimiting.AbstractCurrentlimiter;
import cn.chipsgateway.currentlimiting.CurrentlimiterConfig;

import java.util.Map;

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
