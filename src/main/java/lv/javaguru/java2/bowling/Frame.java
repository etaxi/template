package lv.javaguru.java2.bowling;


public class Frame {
    int firstRollScore;
    int secondRollScore;

    public Frame(int firstRollScore, int secondRollScore) {
        this.firstRollScore = firstRollScore;
        this.secondRollScore = secondRollScore;
    }

    boolean isStrike(){

        if (firstRollScore == 10){
            return true;
        }
        return false;
    }

    boolean isSpare(){

        if ((!isStrike())&&(firstRollScore + secondRollScore == 10)){
            return true;
        }
        return false;
    }

    public int getFirstRollScore() {
        return firstRollScore;
    }

    public int getSecondRollScore() {
        return secondRollScore;
    }

    public void setFirstRollScore(int firstRollScore) {
        this.firstRollScore = firstRollScore;
    }

    public void setSecondRollScore(int secondRollScore) {
        this.secondRollScore = secondRollScore;
    }

    public int getFrameScore() {
        return firstRollScore + secondRollScore;
    }


}
