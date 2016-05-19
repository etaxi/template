package lv.javaguru.java2.Boiling


class BoulingGameTest extends GroovyTestCase {
    void testCalculatePionts() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(10);
        game.CalculatePionts(1);
        int points = game.CalculatePionts(1);
        assertEquals(points, 14);
    }

    void testCalculatePionts2() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(1);
        game.CalculatePionts(1);
        int points = game.CalculatePionts(1);
        assertEquals(points, 3);
    }

    void testCalculatePionts3() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(1);
        game.CalculatePionts(10);
        int points = game.CalculatePionts(1);
        assertEquals(points, 13);
    }

    void testCalculatePionts4() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(5);
        game.CalculatePionts(5);
        int points = game.CalculatePionts(1);
        assertEquals(points, 12);
    }

    void testCalculatePionts5() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(5);
        game.CalculatePionts(5);
        int points = game.CalculatePionts(10);
        assertEquals(points, 30);
    }

}
