package cn.chipsgateway.filter;

public class FilterChainRunner {
    private static final FilterChainRunner INSTANCE = new FilterChainRunner();

    public static FilterChainRunner getInstance() {
        return INSTANCE;
    }

    public void doPreFilter() {
        FilterChainProcess.getInstance().doPreFilter();
    }

    public void doRouteFilter() {
        FilterChainProcess.getInstance().doRouteFilter();
    }

    public void doPostFilter() {
        FilterChainProcess.getInstance().doPostFilter();
    }
}
