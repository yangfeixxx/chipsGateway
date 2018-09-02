package cn.chipsgateway.filter;

import cn.chipsgateway.context.RequestContext;

import java.util.List;

public class FilterChainProcess {
    private static final FilterChainProcess INSTANCE = new FilterChainProcess();

    static FilterChainProcess getInstance() {
        return INSTANCE;
    }

    void doPreFilter() {
        doFilter("pre");
    }

    void doRouteFilter() {
        doFilter("route");
    }

    void doPostFilter() {
        doFilter("post");
    }

    private void doFilter(String pre) {
        List<AbstractChipsGatewayFilter> chipsGatewayFilterList = FiltersLoader.getInstance().getFiltersByType(pre);
        for (int i = 0; i < chipsGatewayFilterList.size(); i++) {
            AbstractChipsGatewayFilter filter = chipsGatewayFilterList.get(i);
            if (!filter.runFilter()) {
                RequestContext currentRequest = RequestContext.getCurrentRequest();
                currentRequest.setFilterState(0);
                return;
            }
        }
    }


}
