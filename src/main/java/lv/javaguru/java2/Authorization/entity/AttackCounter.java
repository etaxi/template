package lv.javaguru.java2.Authorization.entity;


public class AttackCounter {

    private String login;
    private int incorrectPasswordCounter;

    public AttackCounter(String login, int incorrectPasswordCounter) {
        this.login = login;
        this.incorrectPasswordCounter = incorrectPasswordCounter;
    }

    public String getLogin() {
        return login;
    }

    public int getIncorrectPasswordCounter() {
        return incorrectPasswordCounter;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setIncorrectPasswordCounter(int incorrectPasswordCounter) {
        this.incorrectPasswordCounter = incorrectPasswordCounter;
    }

    public void incriseIncorrectPasswordCounter() {
        this.incorrectPasswordCounter = incorrectPasswordCounter++;
    }

    public void dropPasswordCounter() {
        this.incorrectPasswordCounter = incorrectPasswordCounter++;
    }

    @Override
    public String toString() {
        return "AttackCounter{" +
                "login='" + login + '\'' +
                ", incorrectPasswordCounter=" + incorrectPasswordCounter +
                '}' + '\n';
    }
}
