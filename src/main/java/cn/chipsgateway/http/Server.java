package cn.chipsgateway.http;

public class Server {
    private String id;
    private String host;
    private int port = 80;
    private boolean isAliveFlag;
    private ServerGroup serverGroup;
    private boolean isSecure;


    public Server(String id, String host, int port, boolean isAliveFlag, ServerGroup serverGroup, boolean isSecure) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.isAliveFlag = isAliveFlag;
        this.serverGroup = serverGroup;
        this.isSecure = isSecure;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isAliveFlag() {
        return isAliveFlag;
    }

    public void setAliveFlag(boolean aliveFlag) {
        isAliveFlag = aliveFlag;
    }

    public ServerGroup getServerGroup() {
        return serverGroup;
    }

    public void setServerGroup(ServerGroup serverGroup) {
        this.serverGroup = serverGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server = (Server) o;

        if (port != server.port) return false;
        if (isAliveFlag != server.isAliveFlag) return false;
        if (isSecure != server.isSecure) return false;
        if (id != null ? !id.equals(server.id) : server.id != null) return false;
        return host != null ? host.equals(server.host) : server.host == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + port;
        result = 31 * result + (isAliveFlag ? 1 : 0);
        result = 31 * result + (isSecure ? 1 : 0);
        return result;
    }
}
