package cn.chipsgateway.http.balance;

import cn.chipsgateway.http.Server;
import cn.chipsgateway.http.rule.IRule;

import java.util.List;

public interface ILoadBalancer {


    Server chooseServer(Object key);


    List<Server> getServerList(String serverGroupId);


    List<Server> getAllServers();


}
