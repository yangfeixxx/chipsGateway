package cn.chipsgateway.support;

public class GatewayConstant {
    //当前请求
    public static final String REQUEST = "CURRENT_REQUEST";
    //当前响应
    public static final String RESPONSE = "CURRENT_RESPONSE";
    //当前请求地址
    public static final String REQUEST_URL = "CURRENT_REQUEST_URL";
    //当前请求IP
    public static final String REQUEST_IP = "CURRENT_REQUEST_IP";
    //过滤状态
    public static final String FILTER_STATE = "FILTER_STATE";
    //网关响应实体
    public static final String CHIPSRESPONSE = "CHIPS_CURRENT_RESPONSE";
    //前过滤器
    public static final String PREFILTER = "PRE";
    //路由过滤器
    public static final String ROUTERFILTER = "ROUTERFILTER";
    //请求完后过滤器
    public static final String POSTFILTER = "POSTFILTER";
    //未通过的过滤器的类型
    public static final String FAILED_FILTER_TYPE = "FAILEDFILTERTYPE";
    //为什么没有通过过滤器
    public static final String FAILED_FILTER_MESSAGE = "FAILEDFILTERMESSAGE";
}
