package AuthorizationPool.Models;

public class User {
    private String name;
    private String password;
    private Policy policy;

    public User() {
    }

    public User(String name, String password, Policy policy){
        this.name = name;
        this.password = password;
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

}
