package lv.javaguru.java2.bouling;


public class BawlingGame {

    int oneBack, twoBack, sum, frame, knock;

    public BawlingGame() {
        oneBack = 0;
        twoBack = 0;
        sum = 0;
        frame = 1;
        knock = 1;
    }

    public int calculatePoints(int pinsKnock){
        sum = sum + pinsKnock;

        if (frame > 10) {
            return sum;        }

        if (((oneBack + twoBack) == 10)&&(knock == 1)) {
            sum = sum + pinsKnock;
        }

        if ((oneBack == 10)&&(twoBack != 0 )){
            sum = sum + pinsKnock;
        }

        if ((twoBack == 10)&&(oneBack != 10 )) {
            sum = sum + pinsKnock;
        }

        if ((knock == 2)||((pinsKnock == 10)&&(knock == 1))) {
            knock = 1;
            frame = frame + 1;
        }else {
            knock = knock + 1;
        }

        twoBack = oneBack;
        oneBack = pinsKnock;


        return sum;
    }
}
