package org.keraton.unitkata.kata.roman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;

@RunWith(UnitKataRunner.class)
@Verifier(RomanVerifier.class)
@Summary("Write roman kata solution which transform String roman number to an int value.")
public class RomanTest {

    @Solution
    private RomanSolution romanSolution;

    @Test
    public void test(){}



}
