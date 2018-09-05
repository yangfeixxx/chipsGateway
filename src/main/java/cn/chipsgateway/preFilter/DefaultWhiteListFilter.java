package cn.chipsgateway.preFilter;

import cn.chipsgateway.filter.AbstractChipsGatewayFilter;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import static cn.chipsgateway.support.GatewayConstant.PREFILTER;

public class DefaultWhiteListFilter extends AbstractChipsGatewayFilter {
    public boolean shouldFilter() {
        return false;
    }

    public int filterOrder() {
        return -998;
    }

    public String filterType() {
        return PREFILTER;
    }

    public boolean run(GatewayHttpServletRequest request, GatewayHttpServletResponse response) {
        return false;
    }
}
