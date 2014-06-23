package org.keraton.unitkata.kata.bowling_game;

public class BowlingGameDescription {

    public static final String DESCRIPTION =
            "The game consists of 10 frames as shown above.  In each frame the player has\n" +
            "two opportunities to knock down 10 pins.  The score for the frame is the total\n" +
            "number of pins knocked down, plus bonuses for strikes and spares.\n" +
            "\n" +
            "A spare is when the player knocks down all 10 pins in two tries.  The bonus for\n" +
            "that frame is the number of pins knocked down by the next roll.  So in frame 3\n" +
            "above, the score is 10 (the total number knocked down) plus a bonus of 5 (the\n" +
            "number of pins knocked down on the next roll.)\n" +
            "\n" +
            "A strike is when the player knocks down all 10 pins on his first try.  The bonus\n" +
            "for that frame is the value of the next two balls rolled.\n" +
            "\n" +
            "In the tenth frame a player who rolls a spare or strike is allowed to roll the extra\n" +
            "balls to complete the frame.  However no more than three balls can be rolled in\n" +
            "tenth frame.\n" +
            "\n" +
            "Write a class named “Game” that has two methods\n" +
            "   - roll(pins : int) is called each time the player rolls a ball.\n" +
            "     The argument is the number of pins knocked down.\n" +
            "   - score() : int is called only at the very end of the game.\n" +
            "     It returns the total score for that game.\n";
}
