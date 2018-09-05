package cn.chipsgateway.preFilter;

import cn.chipsgateway.Entity.RequestRecordEntity;
import cn.chipsgateway.filter.AbstractChipsGatewayFilter;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;
import cn.chipsgateway.utils.WebHelpUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cn.chipsgateway.support.GatewayConstant.PREFILTER;

public class CurrentlimitingFilter extends AbstractChipsGatewayFilter  {
    public boolean shouldFilter() {
        return true;
    }

    public int filterOrder() {
        return -1000;
    }

    public String filterType() {
        return PREFILTER;
    }


    public boolean run(GatewayHttpServletRequest request, GatewayHttpServletResponse response) {
        String clientIp = WebHelpUtils.getIpAddress(request);
        String url = WebHelpUtils.getRequestUrl(request);
       // clientIp.
        return false;
    }
}
