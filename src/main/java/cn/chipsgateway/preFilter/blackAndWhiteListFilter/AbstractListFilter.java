package cn.chipsgateway.preFilter.blackAndWhiteListFilter;

import cn.chipsgateway.filter.AbstractChipsGatewayFilter;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractListFilter extends AbstractChipsGatewayFilter {
    private static final Map<String, List<String>> IPMAPPERURLS = new HashMap();
    private int blackORwhite = 0;//0:既不是黑名单也不是白名单.1:黑名单,2:白名单

    public int getBlackORwhite() {
        return blackORwhite;
    }

    public void setBlackORwhite(int blackORwhite) {
        this.blackORwhite = blackORwhite;
    }

    List<String> getUrls(String ip) {
        return IPMAPPERURLS.get(ip);
    }

    boolean isExistList(String ip, String url) {
        List<String> urls = getUrls(ip);
        return urls.contains(url);
    }

    public void addList(String ip, List<String> urls) {
        IPMAPPERURLS.put(ip, urls);
    }
}
