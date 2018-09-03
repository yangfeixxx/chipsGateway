package cn.chipsgateway.support;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GatewayHttpServletResponse extends HttpServletResponseWrapper {
    private HttpServletResponse response;
    public GatewayHttpServletResponse(HttpServletResponse response) {
        super(response);
        this.response = response;
    }
}
