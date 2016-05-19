package lv.javaguru.java2.Boiling

// примеры   http://bowling.sin.ru/score.shtml

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

    void testCalculatePionts6() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(9);
        game.CalculatePionts(0);
        game.CalculatePionts(3);
        game.CalculatePionts(7);
        game.CalculatePionts(6);
        int points = game.CalculatePionts(1);
        assertEquals(points, 32);
    }


    void testCalculatePionts7() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(9);
        game.CalculatePionts(0);

        game.CalculatePionts(3);
        game.CalculatePionts(7);

        game.CalculatePionts(6);
        game.CalculatePionts(1);

        game.CalculatePionts(3);
        game.CalculatePionts(7);

        game.CalculatePionts(8);
        game.CalculatePionts(1);

        game.CalculatePionts(5);
        game.CalculatePionts(5);

        game.CalculatePionts(0);
        game.CalculatePionts(10);

        game.CalculatePionts(8);
        game.CalculatePionts(0);

        game.CalculatePionts(7);
        game.CalculatePionts(3);

        game.CalculatePionts(8);
        int points = game.CalculatePionts(8);

        assertEquals(points, 131);
    }

    void testCalculatePionts8() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(9);
        game.CalculatePionts(0);

        game.CalculatePionts(3);
        game.CalculatePionts(5);

        game.CalculatePionts(6);
        game.CalculatePionts(1);

        game.CalculatePionts(3);
        game.CalculatePionts(6);

        game.CalculatePionts(8);
        game.CalculatePionts(1);

        game.CalculatePionts(5);
        game.CalculatePionts(3);

        game.CalculatePionts(2);
        game.CalculatePionts(5);

        game.CalculatePionts(8);
        game.CalculatePionts(0);

        game.CalculatePionts(7);
        game.CalculatePionts(1);

        game.CalculatePionts(8);
        int points = game.CalculatePionts(1);

        assertEquals(points, 82);
    }

    void testCalculatePionts9() {
        BoulingGame game = new BoulingGame();
        game.CalculatePionts(10);

        game.CalculatePionts(3);
        game.CalculatePionts(7);

        game.CalculatePionts(6);
        game.CalculatePionts(1);

        game.CalculatePionts(10);

        game.CalculatePionts(10);

        game.CalculatePionts(10);

        game.CalculatePionts(2);
        game.CalculatePionts(8);

        game.CalculatePionts(9);
        game.CalculatePionts(0);

        game.CalculatePionts(7);
        int points = game.CalculatePionts(3);

        assertEquals(points, 153);
    }
}
