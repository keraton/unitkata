package org.keraton.unitkata.kata.string_calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;

@RunWith(UnitKataRunner.class)
@Verifier(StringCalculatorVerifier.class)
@Summary("Create a simple string calculator, follows hints. Ref. http://osherove.com/tdd-kata-1/")
public class StringCalculatorTest {

    @Solution
    private StringCalculator stringCalculator;

    @Test public void should_test () {

    }

}
