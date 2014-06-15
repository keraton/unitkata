package org.keraton.unitkata.kata.fizzbuzz;

public class FizzBuzzPrinter {

    private final StringBuilder stringBuilder;

    public FizzBuzzPrinter() {
        stringBuilder = new StringBuilder();
    }

    public void println(String string) {
        stringBuilder.append(string);
        System.out.print(string);
    }

    public String getWhatHasBeenPrinted(){
        return stringBuilder.toString();
    }
}
