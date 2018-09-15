package cn.chipsgateway.http.rule;

import cn.chipsgateway.http.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinRole implements IRule {
    private AtomicInteger ai = new AtomicInteger(0);

    @Override
    public Server getServer(List<Server> serverList) {
        int count = serverList.size();
        int currentIndex = getCurrentIndex(count);
        return serverList.get(currentIndex);

    }

    private int getCurrentIndex(int size) {
        //受到Unsafe类getAndAddInt()方法的启发,保证了递增的原子性
        for (; ; ) {
            int current = ai.get();
            int next = (current + 1) % size;//每次next==size的时候都会自动归零,自循环
            if (ai.compareAndSet(current, next))
                return next;
        }
    }
}
