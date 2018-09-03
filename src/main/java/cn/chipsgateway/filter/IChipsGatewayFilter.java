package cn.chipsgateway.filter;

import cn.chipsgateway.Entity.ChipsResponsebody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IChipsGatewayFilter {
    boolean shouldFilter();

    int filterOrder();

    String filterType();

    boolean run(HttpServletRequest request, ChipsResponsebody response);
}
