package cn.chipsgateway.http.balance;

import cn.chipsgateway.http.Server;

import java.util.List;

public interface ILoadBalancer {
    void addServers(List<Server> newServers);


    Server chooseServer(Object key);


    List<Server> getServerList(String serverGroupId);


    List<Server> getAllServers();

    void setRule(IRule rule);

    IRule getRule(IRule lb);

}
