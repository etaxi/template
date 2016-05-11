package lv.javaguru.java2.Authorization.entity;

public class User {

    private String login;
    private String password;
    private boolean blocked;

    public User(String login, String password, boolean blocked) {
        this.login = login;
        this.password = password;
        this.blocked = blocked;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", blocked=" + blocked +
                '}' + '\n';
    }
}
