package cn.chipsgateway.http.balance;

import javax.print.DocFlavor;

public abstract class AbstractLoadBalancer implements ILoadBalancer {

    private IRule rule;

    public void setRule(IRule rule) {
        this.rule = rule;
    }

    public IRule getRule(IRule lb) {
        return lb;
    }

}
