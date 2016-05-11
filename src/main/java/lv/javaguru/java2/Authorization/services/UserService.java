package lv.javaguru.java2.Authorization.services;


import lv.javaguru.java2.Authorization.db.Database;
import lv.javaguru.java2.Authorization.entity.User;

public class UserService {

    Database db;

    public UserService(Database db) {
        this.db = db;
    }


    boolean checkLoginIsEmpty(String login){

        if (login.isEmpty())
            return true;
        else
            return false;
    }

    boolean checkLoginIsNull(String login){

        if (login == null)
            return true;
        else
            return false;
    }

    boolean checkLoginExist(String login){
        User user = db.getUserByLogin(login);
        if (user == null)
            return false;
        else
            return true;
    }

    boolean checkLoginIsBlocked(String login){
        User user = db.getUserByLogin(login);
        if (user.isBlocked())
            return true;
        else
            return false;

    }


    boolean checkPasswordIsEmpty(String password){

        if (password.isEmpty())
            return true;
        else
            return false;
    }

    boolean checkPasswordIsNull(String password){

        if (password == null)
            return true;
        else
            return false;
    }

    boolean checkPasswordIsCorrect(String login, String password){

        User user = db.getUserByLogin(login);
        if (user.getPassword().equals(password) && !user.isBlocked())
            return true;
        else
            return false;
    }

    void blockUser(String login){
        User user = db.getUserByLogin(login);
        user.setBlocked(true);
        db.editUser(user);
    }


}
