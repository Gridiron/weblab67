package model.entity;

/**
 * User Entity
 * @author Mikita Ishchanka
 * @version 1.0
 */
public class User {
    /**
     * User id
     * */
    private int id;


    /**
     * User type
     * */
    private int type;


    /**
     * User's login
     * */
    private String login;

    /**
     * User's password
     * */
    private String password;

    public User(){}
    /**
     * Creates tenant
     * */
    public User(int id, int type, String login, String password){
        this.id = id;
        this.type = type;
        this.login = login;
        this.password = password;
    }

    public User(int type, String login, String password) {
        this.type = type;
        this.login = login;
        this.password = password;
    }

    public void setUser_id(int user_id) {
        this.id = user_id;
    }

    public void setUser_type(int user_type) {
        this.type = user_type;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return id;
    }

    public int getUser_type() {
        return type;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: id: " + this.id +
                "\ntype: " + this.type +
                "\nlogin: " + this.login +
                "\npassword: " + this.password + "\n";
    }
}