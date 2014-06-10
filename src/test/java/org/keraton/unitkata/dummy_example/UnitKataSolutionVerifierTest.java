package org.keraton.unitkata.dummy_example;

import org.junit.Assert;
import org.junit.Test;
import org.keraton.unitkata.annotation.Hint;
import org.keraton.unitkata.annotation.Order;
import org.keraton.unitkata.annotation.Solution;

/**
 * Created by bowiesanggajayabrotosumpeno on 05/06/2014.
 */
public class UnitKataSolutionVerifierTest {

    @Solution
    private DummySolutionImpl solution;

    @Test @Order(1) @Hint("method isTrue() should return 'true'")
    public void should_be_the_solution_number_1() {
        Assert.assertTrue(solution.isTrue());
    }

    @Test @Order(2)
    public void should_be_the_solution_number_2() {
        Assert.assertTrue(solution.isTrue());
    }

}
