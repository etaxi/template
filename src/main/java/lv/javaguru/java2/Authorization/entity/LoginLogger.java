package lv.javaguru.java2.Authorization.entity;

public class LoginLogger {
    private String login;
    private String password;
    private boolean successful;

    public LoginLogger(String login, String password, boolean successful) {
        this.login = login;
        this.password = password;
        this.successful = successful;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSuccessful() {
        return successful;
    }

    @Override
    public String toString() {
        return "LoginLogger{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", successful=" + successful +
                '}' + '\n';
    }
}
