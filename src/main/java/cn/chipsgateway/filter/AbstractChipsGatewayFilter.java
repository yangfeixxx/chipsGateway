package cn.chipsgateway.filter;

import cn.chipsgateway.context.RequestContext;

public abstract class AbstractChipsGatewayFilter implements IChipsGatewayFilter {

    public boolean runFilter() {
        RequestContext currentRequest = RequestContext.getCurrentRequest();
        if (shouldFilter()) {
            return run(currentRequest.getRequest(),  currentRequest.getResponse());
        }
        return true;
    }
}
