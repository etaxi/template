package lv.javaguru.java2.Authorization.services;


import lv.javaguru.java2.Authorization.db.Database;

public class AuthorizationService {

    Database db;
    AttackService attackService;
    LoginLoggerServiсe loginLoggerServiсe;
    UserService userService;

    public AuthorizationService(Database db) {
        this.db = db;
        this.attackService = new AttackService(db);
        this.loginLoggerServiсe = new LoginLoggerServiсe(db);
        this.userService = new UserService(db);
    }

    boolean authorization(String login, String password){

        if (userService.checkLoginIsEmpty(login)) {
            return false;
        }

        if (userService.checkLoginIsNull(login)) {
            return false;
        }

        if (userService.checkPasswordIsEmpty(password)){
            return false;
        }

        if (userService.checkPasswordIsNull(password)){
            return false;
        }

        if (!userService.checkLoginExist(login)){
            return false;
        }

        if (userService.checkLoginIsBlocked(login)){
            loginLoggerServiсe.addLoginLogger(login, password, false);
            return false;
        }

        if (userService.checkPasswordIsCorrect(login, password)){
            loginLoggerServiсe.addLoginLogger(login, password, true);
            attackService.dropCounter(login);
            return true;
        }
        else {
            loginLoggerServiсe.addLoginLogger(login, password, false);
            attackService.incriseCounter(login);
            if (attackService.getCountOfAttack(login) >= 3) {
                userService.blockUser(login);
            }
            return false;
        }

    }

}
