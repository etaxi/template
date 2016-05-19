package lv.javaguru.java2.Boiling;


public class BoulingGame {

    int oneBack, twoBack, threeBack, sum, frame, knock;

    public BoulingGame() {
        oneBack = 0;
        twoBack = 0;
        sum = 0;
        frame = 1;
        knock = 1;
    }

    int CalculatePionts(int pinsKnock){

        if (frame > 10) {
            return sum;
        }


        if (((oneBack + twoBack) == 10)&&(knock == 1)) {
            sum = sum + pinsKnock;
        }

        if (oneBack == 10){
            sum = sum + pinsKnock;
        }

        if (twoBack == 10) {
            sum = sum + pinsKnock;
        }


        sum = sum + pinsKnock;
        twoBack = oneBack;
        oneBack = pinsKnock;

        knock = knock + 1;

        if ((knock == 2)||(pinsKnock == 10)) {
            knock = 0;
            frame = frame + 1;
        }

        return sum;
    }
}
