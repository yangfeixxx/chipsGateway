package cn.chipsgateway.context;

import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;
import cn.chipsgateway.utils.WebHelpUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import static cn.chipsgateway.support.GatewayConstant.*;

import javax.servlet.http.*;
import java.util.concurrent.ConcurrentHashMap;

public class RequestContext extends ConcurrentHashMap<String, Object> {
    protected static final ThreadLocal<? extends RequestContext> threadLocal = new ThreadLocal<RequestContext>() {
        protected RequestContext initialValue() {
            //复写initialValue()方法,只是为了避免每次新线程get后为空,还要判断然后set
            try {
                return new RequestContext();
            } catch (Throwable var2) {
                throw new RuntimeException(var2);
            }
        }
    };

    public static RequestContext getCurrentRequest() {
        return threadLocal.get();
    }

    public void clean() {
        threadLocal.remove();
    }

    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.put(REQUEST, new GatewayHttpServletRequest(request));
        this.put(RESPONSE, new GatewayHttpServletResponse(response));
        this.put(REQUEST_URL, WebHelpUtils.getRequestUrl(request));
        this.put(REQUEST_IP, WebHelpUtils.getIpAddress(request));
    }

    public GatewayHttpServletResponse getResponse() {
        return (GatewayHttpServletResponse) this.get(RESPONSE);
    }

    public GatewayHttpServletRequest getRequest() {
        return (GatewayHttpServletRequest) this.get(REQUEST);
    }

    public String getRequestUrl() {
        return (String) this.get(REQUEST_URL);
    }

    public void setFailedFilterIpVisitUrlErrorMessage() {
        setFailedFilterMessage("IP: [" + this.getRequestIP() + "] 访问url: [" + this.getRequestUrl() + "] 失败,原因:未在白名单之中");
    }


    public String getRequestIP() {
        return (String) this.get(REQUEST_IP);
    }

    public void setFilterState(int state) {
        this.put(FILTER_STATE, state);
    }

    public void setFailedFilterMessage(String message) {
        this.put(FAILED_FILTER_MESSAGE, message);
    }

    public void setFailedFilterType(String type) {
        this.put(FAILED_FILTER_TYPE, type);
    }
}
