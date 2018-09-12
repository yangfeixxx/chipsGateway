package cn.chipsgateway.http.balance;

//定义负载均衡规则:比如轮询,随机,权重,动态时间,hash
public interface IRule {

    void getServer(Object key);


}
