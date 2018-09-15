package cn.chipsgateway.http.rule;

import cn.chipsgateway.http.Server;

import java.util.List;
import java.util.Random;

public class RandomRole implements IRule {
    public Random random = new Random();

    @Override
    public Server getServer(List<Server> serverList) {
        return serverList.get(random.nextInt(serverList.size()));
    }
}
