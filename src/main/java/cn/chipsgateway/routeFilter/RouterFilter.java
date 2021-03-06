package cn.chipsgateway.routeFilter;

import cn.chipsgateway.filter.AbstractChipsGatewayFilter;
import cn.chipsgateway.strategy.ChooseStrategy;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;

import static cn.chipsgateway.support.GatewayConstant.ROUTERFILTER;

public class RouterFilter extends AbstractChipsGatewayFilter {
    private ChooseStrategy choiceStrategy;

    public RouterFilter(ChooseStrategy choiceStrategy) {
        this.choiceStrategy = choiceStrategy;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return ROUTERFILTER;
    }

    @Override
    public boolean run(GatewayHttpServletRequest request, GatewayHttpServletResponse response) {
        choiceStrategy.choice();
        return true;
    }
}
