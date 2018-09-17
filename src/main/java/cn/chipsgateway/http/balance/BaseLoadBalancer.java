package cn.chipsgateway.http.balance;

import cn.chipsgateway.http.Server;

import java.util.List;


public class BaseLoadBalancer extends AbstractLoadBalancer {

    @Override
    public Server chooseServer(Object key) {
        for (; ; ) {
            List<Server> serverList = getServerList((String) key);
            if (Thread.interrupted()) {
                //获取超时将被打断
                return null;
            }
            if (serverList == null) {
                //考虑到服务器列表还在被拉取或者超时重置,但是请求已经进来的情况.
                //此时让出CPU资源
                Thread.yield();
                continue;
            }
            //因为如果拉到了服务器列表就不会为0,所以不用做为0的判断了
            Server server = getRule().getServer(serverList);

            server = server.isAliveFlag() ? server : null;
            if (server == null) {
                //可能Server已经挂掉了（因为心跳机制由定时线程维护）,但是服务器列表还没来得及重置.
                //此时让出CPU资源,当然CPU也可能再次选择此线程
                Thread.yield();
                continue;
            }
            return server;
        }
    }

    @Override
    public List<Server> getServerList(String serverGroupId) {
        return null;
    }

    @Override
    public List<Server> getAllServers() {
        return null;
    }


}
