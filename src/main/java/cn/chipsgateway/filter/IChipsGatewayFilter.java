package cn.chipsgateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IChipsGatewayFilter {
    boolean shouldFilter();

    int filterOrder();

    String filterType();

    boolean run(HttpServletRequest request, HttpServletResponse response);
}
