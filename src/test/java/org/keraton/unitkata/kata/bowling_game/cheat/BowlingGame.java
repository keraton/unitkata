package org.keraton.unitkata.kata.bowling_game.cheat;

public class BowlingGame {

    private int[] rolls = new int[21];
    private int rollNumber = 0;

    public void roll(int pins) {
        rolls[rollNumber++] = pins;
    }

    public int score(){
        int score = 0;
        int rollCounter = 0;
        for(int frame=0; frame<10; frame++) {
            if (rolls[rollCounter] == 10) {
                score += 10 + rolls[rollCounter+1] + rolls[rollCounter+2];
                rollCounter++;
            }
            else if (rolls[rollCounter] + rolls[rollCounter+1] == 10) {
                score += 10 + rolls[rollCounter+2];
                rollCounter += 2;
            }
            else {
                score += rolls[rollCounter] + rolls[rollCounter + 1];
                rollCounter += 2;
            }
        }
        return score;
    }


}
