package lv.javaguru.java2.bouling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoulingGameTestSavonin {

    @Test
    public void shouldReturn0IfNoPinsKnockedInFirstFrameFirstAttempt() {
        BawlingGame game = new BawlingGame();
        int points = game.calculatePoints(0);
        assertEquals(points, 0);
    }

    @Test
    public void shouldReturn1ThenReturn1InFirstFrameFirstAttempt() {
        BawlingGame game = new BawlingGame();
        int points = game.calculatePoints(1);
        assertEquals(points, 1);
    }

    @Test
    public void shouldReturnSumOfTwoBallRollsInFirstFrame() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 2);
    }

    @Test
    public void strikeInFirstFrame() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 14);
    }

    @Test
    public void notStrikeInFirstFrame() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(0);
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 13);
    }

    @Test
    public void spareInFirstFrame() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, 12);
    }

    @Test
    public void notSpareInFirstFrame() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(1);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, 12);
    }

    @Test
    public void twoStrikesInARow() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 10 + 1) + (10 + 1 + 1) + 1 + 1);
    }

    @Test
    public void threeStrikesInARow() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 10 + 10) + (10 + 10 + 1) + (10 + 1 + 1) + 1 + 1);
    }

    @Test
    public void twoSparesInARow() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (5 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void threeSparesInARow() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (5 + 5 + 5) + (5 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void strikeAndSpareInARow() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void twoStrikesAndSpareInARow() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 10 + 5) + (10 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void elevenFrameNotCount() {
        BawlingGame game = new BawlingGame();
        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        game.calculatePoints(1);

        game.calculatePoints(1);
        int points = game.calculatePoints(1);

        assertEquals(points, 20);
    }

}