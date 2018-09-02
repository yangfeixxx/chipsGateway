package cn.chipsgateway.filter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FiltersLoader {
    private static final FiltersLoader INSTANCE = new FiltersLoader();
    private Map<String, List<AbstractChipsGatewayFilter>> filterMap = new ConcurrentHashMap();

    static FiltersLoader getInstance() {
        return INSTANCE;
    }

    List<AbstractChipsGatewayFilter> getFiltersByType(String type) {
        return filterMap.get(type);
    }

}
