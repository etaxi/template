package lv.javaguru.java2.domain;

/**
 * Created by Viktor on 01/07/2014.
 */
public class User {

    private long userId;
    public String firstName;
    public String lastName;


    public User() {
    }

    public User(String firstName, String lastName) {
        this.userId = 0;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
