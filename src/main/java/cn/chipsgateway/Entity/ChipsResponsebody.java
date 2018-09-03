package cn.chipsgateway.Entity;

import java.util.Map;

public class ChipsResponsebody {
    private int state;
    private Object reponseBody;
    private Map heads;
    private String msg;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getReponseBody() {
        return reponseBody;
    }

    public void setReponseBody(Object reponseBody) {
        this.reponseBody = reponseBody;
    }

    public Map getHeads() {
        return heads;
    }

    public void setHeads(Map heads) {
        this.heads = heads;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
