package cn.chipsgateway.preFilter;

import cn.chipsgateway.Entity.ChipsResponsebody;
import cn.chipsgateway.filter.AbstractChipsGatewayFilter;

import javax.servlet.http.HttpServletRequest;

import static cn.chipsgateway.support.GatewayConstant.PREFILTER;

public class DefaultBlackListFilter extends AbstractChipsGatewayFilter {
    public boolean shouldFilter() {
        return false;
    }

    public int filterOrder() {
        return -999;
    }

    public String filterType() {
        return PREFILTER;
    }

    public boolean run(HttpServletRequest request, ChipsResponsebody response) {
        return false;
    }
}
