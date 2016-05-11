package lv.javaguru.java2.Authorization.services;


import lv.javaguru.java2.Authorization.db.Database;
import lv.javaguru.java2.Authorization.entity.AttackCounter;

public class AttackService {

    Database db;

    AttackService(Database db) {
        this.db = db;
    }

    void incriseCounter (String login){
        AttackCounter attackCounter = db.getAttackCounterByLogin(login);
        if (attackCounter == null){
            db.addAttackCounter(new AttackCounter(login,1));
        }
        else{
            attackCounter.incriseIncorrectPasswordCounter();
            db.editAttackCounter(attackCounter);
        }
    }


    int getCountOfAttack (String login){
        AttackCounter attackCounter = db.getAttackCounterByLogin(login);
        return attackCounter.getIncorrectPasswordCounter();
    }

    void dropCounter (String login){
        AttackCounter attackCounter = db.getAttackCounterByLogin(login);
        if (attackCounter == null){
            db.addAttackCounter(new AttackCounter(login,0));
        }
        else {
            attackCounter.dropPasswordCounter();
            db.editAttackCounter(attackCounter);
        }

    }

}
