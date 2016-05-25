package lv.javaguru.java2.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<Frame>();
    private int frameCounter = 1;
    private int knockCounter = 1;
    private int prevPinsKnock = 0;

    public int calculatePoints(int pinsKnock){
        checkPinKnock(pinsKnock);
        addFramePins(pinsKnock);
        int score = calculateScore();
        prevPinsKnock = pinsKnock;
        setCounter();
        return score;

    }

    int calculateScore(){
        int sum = 0;
        for (int i = 0; i <= frameCounter-1; i++) {

            if (i > 9){ break;}

            Frame currFrame = frames.get(i);

            Frame nextFrame = new Frame(0,0);
            if (frameCounter > i + 1) { nextFrame = frames.get(i+1);  }

            Frame nextNextFrame = new Frame(0,0);
            if (frameCounter > i + 2) { nextNextFrame = frames.get(i+2);}

            sum = sum + currFrame.getFrameScore();

            if (currFrame.isStrike()) {
                sum = sum + nextFrame.getFrameScore();
            }

            if (nextFrame.isStrike()) {
                sum = sum + nextNextFrame.getFirstRollScore();
            }

            if (currFrame.isSpare()){
                sum = sum + nextFrame.getFirstRollScore();
            }
        }
        return sum;
    }

    void addFramePins(int pinsKnock){

        if ((knockCounter == 2)&&(prevPinsKnock == 10)){   //after Strike
            frames.add(new Frame(pinsKnock,0));
        }

        else if (knockCounter == 1){                             //after first knock
            frames.add(new Frame(pinsKnock,0));
        }

        else if (knockCounter == 2){                             //after second knock
            Frame frame = frames.get(frameCounter-1);
            frame.setSecondRollScore(pinsKnock);
            frames.set(frameCounter-1, frame);
        }
    }

    void checkPinKnock(int pinsKnock){
        if ((pinsKnock < 0)||(pinsKnock > 10)){
            throw new BowlingException("illegal argument " + pinsKnock);
        }
    }

    void setCounter(){

        if ((knockCounter == 1)&&(prevPinsKnock == 10)){
            knockCounter = 0;
            frameCounter ++;
        }

        if (knockCounter == 2){
            knockCounter = 0;
            frameCounter ++;
        }
        knockCounter ++ ;
    }

}
