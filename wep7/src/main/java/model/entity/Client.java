package model.entity;

/**
 * Task Entity
 * @author Mikita Ishchanka
 * @version 1.0
 */
public class Client {
    /**
     * client id
     */
    private int client_id;
    /**
     * client name
     */
    private String name;
    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(int client_id, String name) {
        this.client_id = client_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", name='" + name + '\'' +
                '}';
    }
}
