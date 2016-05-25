package lv.javaguru.java2.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void shouldReturn0IfNoPinsKnockedInFirstFrameFirstAttempt() {
        BowlingGame game = new BowlingGame();
        int points = game.calculatePoints(0);
        assertEquals(points, 0);
    }

    @Test
    public void shouldReturn1ThenReturn1InFirstFrameFirstAttempt() {
        BowlingGame game = new BowlingGame();
        int points = game.calculatePoints(1);
        assertEquals(points, 1);
    }

    @Test
    public void shouldReturnSumOfTwoBallRollsInFirstFrame() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 2);
    }

    @Test
    public void strikeInFirstFrame() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 14);
    }

    @Test
    public void notStrikeInFirstFrame() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(0);
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, 13);
    }

    @Test
    public void spareInFirstFrame() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, 12);
    }

    @Test
    public void notSpareInFirstFrame() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(1);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, 12);
    }

    @Test
    public void twoStrikesInARow() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 10 + 1) + (10 + 1 + 1) + 1 + 1);
    }

    @Test
    public void threeStrikesInARow() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(1);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 10 + 10) + (10 + 10 + 1) + (10 + 1 + 1) + 1 + 1);
    }

    @Test
    public void twoSparesInARow() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (5 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void threeSparesInARow() {
        BowlingGame game = new BowlingGame();
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
        BowlingGame game = new BowlingGame();
        game.calculatePoints(10);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void twoStrikesAndSpareInARow() {
        BowlingGame game = new BowlingGame();
        game.calculatePoints(10);
        game.calculatePoints(10);
        game.calculatePoints(5);
        game.calculatePoints(5);
        int points = game.calculatePoints(1);
        assertEquals(points, (10 + 10 + 5) + (10 + 5 + 5) + (5 + 5 + 1) + 1);
    }

    @Test
    public void elevenFrameNotCount() {
        BowlingGame game = new BowlingGame();
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