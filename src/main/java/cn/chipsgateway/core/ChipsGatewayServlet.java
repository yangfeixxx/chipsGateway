package cn.chipsgateway.core;

import cn.chipsgateway.context.RequestContext;
import cn.chipsgateway.filter.FilterChainRunner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChipsGatewayServlet extends HttpServlet {
    private static FilterChainRunner filterChainRunner;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        filterChainRunner = FilterChainRunner.getInstance();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestContext currentRequest = RequestContext.getCurrentRequest();
        try {
            currentRequest.init(req, resp);

            try {
                filterChainRunner.doPreFilter();
            } catch (Exception e) {
                e.printStackTrace();
                filterChainRunner.doPostFilter();
            }


            try {
                filterChainRunner.doRouteFilter();
            } catch (Exception e) {
                e.printStackTrace();
                filterChainRunner.doPostFilter();
            }


            try {
                filterChainRunner.doPostFilter();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } finally {
            currentRequest.clean();
        }
    }

    @Override
    public void destroy() {
    }
}
