package cn.chipsgateway.http.balance;

import cn.chipsgateway.http.rule.IRule;

public abstract class AbstractLoadBalancer implements ILoadBalancer {

    private IRule rule;

    public void setRule(IRule rule) {
        this.rule = rule;
    }

    public IRule getRule() {
        return rule;
    }

}
