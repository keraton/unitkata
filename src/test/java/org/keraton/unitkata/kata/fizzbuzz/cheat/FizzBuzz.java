package org.keraton.unitkata.kata.fizzbuzz.cheat;

import org.keraton.unitkata.kata.fizzbuzz.FizzBuzzPrinter;

public class FizzBuzz {

    public FizzBuzzPrinter printNumbers() {
        FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter();
        for(int i=1; i<=100; i++)
            fizzBuzzPrinter.println(i+",");

        return fizzBuzzPrinter;
    }

    public FizzBuzzPrinter printNumbersWithFizz() {
        FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter();
        for(int i=1; i<=100; i++) {
            fizzBuzzPrinter.println(getNumberOrFizz(i) + ",");
        }

        return fizzBuzzPrinter;
    }

    private String getNumberOrFizz(int i) {
        if (i % 3 == 0)
            return "Fizz";
        return i+"";
    }

    public FizzBuzzPrinter printNumbersWithBuzz() {
        FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter();
        for(int i=1; i<=100; i++) {
            fizzBuzzPrinter.println(getNumberOrBuzz(i) + ",");
        }

        return fizzBuzzPrinter;
    }

    private String getNumberOrBuzz(int i) {
        if (i % 5 == 0)
            return "Buzz";
        return i+"";
    }

    public FizzBuzzPrinter printNumbersWithFizzBuzz() {
        FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter();
        for(int i=1; i<=100; i++) {
            fizzBuzzPrinter.println(getNumberOrFizzBuzz(i) + ",");
        }

        return fizzBuzzPrinter;
    }

    private String getNumberOrFizzBuzz(int i) {
        String fizzBuzz = "";
        if(i % 3 == 0)
            fizzBuzz += "Fizz";
        if(i % 5 == 0)
            fizzBuzz += "Buzz";
        if (fizzBuzz.isEmpty())
            return i+"";
        return fizzBuzz;
    }

    public String getFizzBuzzOrNumber(int number) {
        if (number>100) throw new IllegalArgumentException();
        if (number<1) throw new IllegalArgumentException();
        return getNumberOrFizzBuzz(number);
    }
}
