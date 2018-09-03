package cn.chipsgateway.context;

import cn.chipsgateway.Entity.ChipsResponsebody;
import cn.chipsgateway.support.GatewayHttpServletRequest;
import cn.chipsgateway.support.GatewayHttpServletResponse;

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
        this.put(CHIPSRESPONSE, new ChipsResponsebody());
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse) this.get(RESPONSE);
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) this.get(REQUEST);
    }

    public ChipsResponsebody getChipsResponse() {
        return (ChipsResponsebody) this.get(CHIPSRESPONSE);
    }

    public void setFilterState(int state) {
        this.put(FILTER_STATE, state);
    }
}
