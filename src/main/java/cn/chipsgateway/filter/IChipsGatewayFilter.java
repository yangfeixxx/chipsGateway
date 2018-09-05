package cn.chipsgateway.filter;

import cn.chipsgateway.core.ChipsGatewayServlet;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;

import javax.servlet.http.HttpServletRequest;

public interface IChipsGatewayFilter {
    boolean shouldFilter();

    int filterOrder();

    String filterType();

    boolean run(GatewayHttpServletRequest request, GatewayHttpServletResponse response);
}
