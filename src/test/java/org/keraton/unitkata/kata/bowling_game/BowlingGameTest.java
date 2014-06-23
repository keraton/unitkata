package org.keraton.unitkata.kata.bowling_game;

import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;

@RunWith(UnitKataRunner.class)
@Verifier(BowlingGameVerifier.class)
@Summary(BowlingGameDescription.DESCRIPTION)
public class BowlingGameTest {

    @Solution
    private BowlingGame bowlingGame;

}
