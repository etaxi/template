package lv.javaguru.java2.Authorization.services;


import lv.javaguru.java2.Authorization.db.Database;
import lv.javaguru.java2.Authorization.entity.LoginLogger;

public class LoginLoggerServiсe {
    Database db;

    LoginLoggerServiсe(Database db) {
        this.db = db;
    }

    void addLoginLogger(String login, String password, boolean successful){
        db.addLoginLogger(new LoginLogger(login, password, successful));
    }

}
