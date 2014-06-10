package org.keraton.unitkata.dummy_example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;

/**
 * Created by bowiesanggajayabrotosumpeno on 05/06/2014.
 */
@RunWith(UnitKataRunner.class)
@Verifier(UnitKataSolutionVerifierTest.class)
@Summary("You need to implement the isTrue methods wich return true, see DummySolutionImpl.java")
public class UnitKataRunnerTest {

    @Solution
    private DummySolutionImpl solution;


    @Test
    public void should_be_called_by_unit_kata_runner() {
    }

    @Test
    public void should_be_called_by_unit_kata_runner_2() {
    }

}
