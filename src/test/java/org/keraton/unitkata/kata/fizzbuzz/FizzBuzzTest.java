package org.keraton.unitkata.kata.fizzbuzz;

import org.junit.runner.RunWith;
import org.keraton.unitkata.UnitKataRunner;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;

@RunWith(UnitKataRunner.class)
@Verifier(FizzBuzzVerifier.class)
@Summary("Write a program that prints the numbers from 1 to 100. But for multiples of three print \"Fizz\"\n" +
        "instead of the number and for the multiples of five print \"Buzz\". For numbers which are multiples of both\n" +
        "three and five print \"FizzBuzz\".")
public class FizzBuzzTest {

    @Solution
    private FizzBuzz fizzBuzz;

}
