package org.keraton.unitkata.dummy_example;

import org.junit.Assert;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

public class UnitKataSolutionVerifierTest {

    @Solution
    private DummySolutionImpl solution;

    @Solve(order = 1, hint = "method isTrue() should return 'true'")
    public void should_be_the_solution_number_1() {
        Assert.assertTrue(solution.isTrue());
    }

    @Solve(order = 1, hint ="dummy hint")
     public void should_be_the_solution_number_2() {
        Assert.assertTrue(solution.isTrue());
    }

}
