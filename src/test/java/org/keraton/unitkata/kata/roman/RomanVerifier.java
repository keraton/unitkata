package org.keraton.unitkata.kata.roman;

import org.junit.Assert;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

public class RomanVerifier {

    @Solution
    private RomanSolution romanSolution;

    @Solve(order = 1, hint = "Should return 0 when given an empty string")
    public void verify1() {
        Assert.assertEquals(0, romanSolution.romanToInt(""));
    }

    @Solve(order = 2, hint = "Should return 1 when given a letter I")
    public void verify2() {
        Assert.assertEquals(1,romanSolution.romanToInt("I"));
    }

    @Solve(order = 3, hint = "Should return 5 when given a letter V")
    public void verify3() {
        Assert.assertEquals(5,romanSolution.romanToInt("V"));
    }

    @Solve(order = 4, hint = "Should return 10 when given a letter X")
    public void verify4() {
        Assert.assertEquals(10,romanSolution.romanToInt("X"));
    }

    @Solve(order = 5, hint = "Should return 2 when given a letter II")
    public void verify5() {
        Assert.assertEquals(2,romanSolution.romanToInt("II"));
    }

    @Solve(order = 6, hint = "Should return 4 when given a letter IV")
    public void verify6() {
        Assert.assertEquals(4,romanSolution.romanToInt("IV"));
    }



}
