package lv.javaguru.java2.Authorization.db;



import lv.javaguru.java2.Authorization.entity.AttackCounter;
import lv.javaguru.java2.Authorization.entity.LoginLogger;
import lv.javaguru.java2.Authorization.entity.User;

import java.util.ArrayList;

public class Database {

    private ArrayList<User> usersList = new ArrayList<User>();
    private ArrayList<LoginLogger> loginLoggersList = new ArrayList<LoginLogger>();
    private ArrayList<AttackCounter> attackContorollersList = new ArrayList<AttackCounter>();

    public Database() {
        this.usersList.add(new  User("user1","password1", false));
        this.usersList.add(new  User("user2","password2", true));
        this.usersList.add(new  User("user3","password3", false));

        this.loginLoggersList.add(new LoginLogger("user1","password1", true));
        this.loginLoggersList.add(new LoginLogger("user1","abc", false));
        this.loginLoggersList.add(new LoginLogger("user2","abc", false));
        this.loginLoggersList.add(new LoginLogger("user2","abc", false));
        this.loginLoggersList.add(new LoginLogger("user2","abc", false));
        this.loginLoggersList.add(new LoginLogger("user3","password3", true));

        this.attackContorollersList.add(new AttackCounter("user1", 1));
        this.attackContorollersList.add(new AttackCounter("user2", 3));
        this.attackContorollersList.add(new AttackCounter("user3", 0));
    }


    public User getUserByLogin(String login){

        for (User object: usersList) {
            if (object.getLogin() == login)
                return object;
        }
        return null;
    }

    public ArrayList<LoginLogger> getLoginLoggerCountByLogin(String login){

        ArrayList<LoginLogger> LogByLogin = new ArrayList<LoginLogger>();
        for (LoginLogger object: loginLoggersList) {
            if (object.getLogin() == login)
                LogByLogin.add(object);
        }
        return LogByLogin;
    }

    public AttackCounter getAttackCounterByLogin(String login){

        for (AttackCounter object: attackContorollersList) {
            if (object.getLogin() == login)
                return object;
        }
        return null;
    }


    public boolean editUser(User user){

        for(int i=0; i < usersList.size(); i++) {
            if (usersList.get(i).equals(user)){
                usersList.set(i, user);
                return true;}
        }
        return false;
    }

    public boolean editLoginLogger(LoginLogger loginLogger){

        for(int i=0; i < loginLoggersList.size(); i++) {
            if (loginLoggersList.get(i).equals(loginLogger)){
                loginLoggersList.set(i,loginLogger);
                return true;}
        }
        return false;
    }

    public boolean editAttackCounter(AttackCounter attackCounter){

        for(int i=0; i < attackContorollersList.size(); i++) {
            if (attackContorollersList.get(i).equals(attackCounter)){
                attackContorollersList.set(i,attackCounter);
                return true;
            }
        }
        return false;
    }


    public void addUser(User user){

       usersList.add(user);
    }

    public void addLoginLogger(LoginLogger loginLogger){

        loginLoggersList.add(loginLogger);
    }

    public void addAttackCounter(AttackCounter attackCounter){

        attackContorollersList.add(attackCounter);
    }

    @Override
    public String toString() {
        return "Database{" + '\n' +
                "usersList=" + '\n' + usersList +
                "loginLoggersList=" + '\n' + loginLoggersList +
                "attackContorollersList=" + '\n' + attackContorollersList +
                '}';
    }
}
