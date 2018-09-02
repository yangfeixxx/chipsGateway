package cn.chipsgateway.support;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GatewayHttpServletRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public GatewayHttpServletRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        return super.getParameter(name);
    }

}
