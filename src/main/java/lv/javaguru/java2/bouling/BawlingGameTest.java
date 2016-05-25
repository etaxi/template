package lv.javaguru.java2.bouling;

import org.junit.Test;
import static org.junit.Assert.*;


public class BawlingGameTest {

    @Test
    public void testCalculatePionts() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 14);
    }

    @Test
    public void testCalculatePionts2() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(1);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 3);
    }

    @Test
    public void testCalculatePionts3() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(1);
        game.calculatePoints(10);
        int points = game.calculatePoints(1);
        assertEquals(points, 13);
    }

    @Test
    public void testCalculatePionts4() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, 12);
    }

    @Test
    public void testCalculatePionts5() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(10);
        assertEquals(points, 30);
    }

    @Test
    public void testCalculatePionts6() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(9);
        game.calculatePoints(0);
        game.calculatePoints(3);
        game.calculatePoints(7);
        game.calculatePoints(6);
        int points = game.calculatePoints(1);
        assertEquals(points, 32);
    }

    @Test
    public void testCalculatePionts7() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(9);
        game.calculatePoints(0);

        game.calculatePoints(3);
        game.calculatePoints(7);

        game.calculatePoints(6);
        game.calculatePoints(1);

        game.calculatePoints(3);
        game.calculatePoints(7);

        game.calculatePoints(8);
        game.calculatePoints(1);

        game.calculatePoints(5);
        game.calculatePoints(5);

        game.calculatePoints(0);
        game.calculatePoints(10);

        game.calculatePoints(8);
        game.calculatePoints(0);

        game.calculatePoints(7);
        game.calculatePoints(3);

        int points = game.calculatePoints(8);

        assertEquals(points, 121);
    }

    @Test
    public void testCalculatePionts8() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(9);
        game.calculatePoints(0);

        game.calculatePoints(3);
        game.calculatePoints(5);

        game.calculatePoints(6);
        game.calculatePoints(1);

        game.calculatePoints(3);
        game.calculatePoints(6);

        game.calculatePoints(8);
        game.calculatePoints(1);

        game.calculatePoints(5);
        game.calculatePoints(3);

        game.calculatePoints(2);
        game.calculatePoints(5);

        game.calculatePoints(8);
        game.calculatePoints(0);

        game.calculatePoints(7);
        game.calculatePoints(1);

        game.calculatePoints(8);
        int points = game.calculatePoints(1);

        assertEquals(points, 82);
    }

    @Test
    public void testCalculatePionts9() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);

        game.calculatePoints(3);
        game.calculatePoints(7);

        game.calculatePoints(6);
        game.calculatePoints(1);

        game.calculatePoints(10);

        game.calculatePoints(10);

        game.calculatePoints(10);

        game.calculatePoints(2);
        game.calculatePoints(8);

        game.calculatePoints(9);
        game.calculatePoints(0);

        game.calculatePoints(7);
        int points = game.calculatePoints(3);

        assertEquals(points, 153);
    }

}