package cn.chipsgateway.http.rule;

import cn.chipsgateway.http.Server;

import java.util.List;

//定义负载均衡规则:比如轮询,随机,权重,动态时间,hash
public interface IRule {

    Server getServer(List<Server> serverList);


}
