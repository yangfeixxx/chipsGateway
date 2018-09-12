package cn.chipsgateway.http;

import java.util.ArrayList;
import java.util.List;

public class ServerGroup {
    private String serverGroupName;
    private List<Server> servers;


    public ServerGroup(String id, String serverGroupName, List<Server> servers) {

        this.serverGroupName = serverGroupName;
        this.servers = servers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerGroup that = (ServerGroup) o;

        return serverGroupName != null ? serverGroupName.equals(that.serverGroupName) : that.serverGroupName == null;
    }

    @Override
    public int hashCode() {
        return serverGroupName != null ? serverGroupName.hashCode() : 0;
    }


    public String getServerGroupName() {
        return serverGroupName;
    }

    public void setServerGroupName(String serverGroupName) {
        this.serverGroupName = serverGroupName;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
}
