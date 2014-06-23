package org.keraton.unitkata.kata.bowling_game;

import org.junit.Before;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

import static org.junit.Assert.assertEquals;

public class BowlingGameVerifier {

    @Solution
    private BowlingGame bowlingGame;

    @Before
    public void setup(){
        bowlingGame = new BowlingGame();
    }

    @Solve(order = 1, hint = "Gutter game, a game when all the ball go to gutter, 0, ..., 0 => 0")
    public void verify_1() {
        for (int i=0; i<20; i++)
            bowlingGame.roll(0);

        assertEquals(0, bowlingGame.score());
    }

    @Solve(order = 2, hint = "All ones game, 1, ..., 1 => 20")
    public void verify_2() {
        for (int i=0; i<20; i++)
            bowlingGame.roll(1);

        assertEquals(20, bowlingGame.score());
    }

    @Solve(order = 3, hint = "Spare one game, follows by gutter games, 5, 5, 3, 0, ... 0 => 16")
    public void verify_3() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(3);

        for (int i=0; i<17; i++)
            bowlingGame.roll(0);

        assertEquals(16, bowlingGame.score());
    }

    @Solve(order = 4, hint = "Like spare game, follows by gutter games, 0, 5, 5, 2, 0, ... 0 => 12")
    public void verify_4() {
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(2);

        for (int i=0; i<16; i++)
            bowlingGame.roll(0);

        assertEquals(12, bowlingGame.score());
    }

    @Solve(order = 5, hint = "Strike one game, follows by gutter games, 10, 3, 4, 0, ... 0 => 24")
    public void verify_5() {
        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(4);

        for (int i=0; i<16; i++)
            bowlingGame.roll(0);

        assertEquals(24, bowlingGame.score());
    }

    @Solve(order = 6, hint = "Perfect games, 10, ... 10 => 300")
    public void verify_6() {
        for (int i=0; i<12; i++)
            bowlingGame.roll(10);

        assertEquals(300, bowlingGame.score());
    }
}
