package org.keraton.unitkata.kata.fizzbuzz;

import org.junit.Assert;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

public class FizzBuzzVerifier {

    public static final String EXPECTED_1_100 = "1,2,3,4,5,6,7,8,9,10," +
                                                "11,12,13,14,15,16,17,18,19,20," +
                                                "21,22,23,24,25,26,27,28,29,30," +
                                                "31,32,33,34,35,36,37,38,39,40," +
                                                "41,42,43,44,45,46,47,48,49,50," +
                                                "51,52,53,54,55,56,57,58,59,60," +
                                                "61,62,63,64,65,66,67,68,69,70," +
                                                "71,72,73,74,75,76,77,78,79,80," +
                                                "81,82,83,84,85,86,87,88,89,90," +
                                                "91,92,93,94,95,96,97,98,99,100,";

    public static final String EXPECTED_FIZZ = "1,2,Fizz,4,5,Fizz,7,8,Fizz,10," +
                                                "11,Fizz,13,14,Fizz,16,17,Fizz,19,20," +
                                                "Fizz,22,23,Fizz,25,26,Fizz,28,29,Fizz," +
                                                "31,32,Fizz,34,35,Fizz,37,38,Fizz,40," +
                                                "41,Fizz,43,44,Fizz,46,47,Fizz,49,50," +
                                                "Fizz,52,53,Fizz,55,56,Fizz,58,59,Fizz," +
                                                "61,62,Fizz,64,65,Fizz,67,68,Fizz,70," +
                                                "71,Fizz,73,74,Fizz,76,77,Fizz,79,80," +
                                                "Fizz,82,83,Fizz,85,86,Fizz,88,89,Fizz," +
                                                "91,92,Fizz,94,95,Fizz,97,98,Fizz,100,";

    public static final String EXPECTED_BUZZ = "1,2,3,4,Buzz,6,7,8,9,Buzz," +
                                                "11,12,13,14,Buzz,16,17,18,19,Buzz," +
                                                "21,22,23,24,Buzz,26,27,28,29,Buzz," +
                                                "31,32,33,34,Buzz,36,37,38,39,Buzz," +
                                                "41,42,43,44,Buzz,46,47,48,49,Buzz," +
                                                "51,52,53,54,Buzz,56,57,58,59,Buzz," +
                                                "61,62,63,64,Buzz,66,67,68,69,Buzz," +
                                                "71,72,73,74,Buzz,76,77,78,79,Buzz," +
                                                "81,82,83,84,Buzz,86,87,88,89,Buzz," +
                                                "91,92,93,94,Buzz,96,97,98,99,Buzz,";

    public static final String EXPECTED_FIZZ_BUZZ = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz," +
                                                "11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz," +
                                                "Fizz,22,23,Fizz,Buzz,26,Fizz,28,29,FizzBuzz," +
                                                "31,32,Fizz,34,Buzz,Fizz,37,38,Fizz,Buzz," +
                                                "41,Fizz,43,44,FizzBuzz,46,47,Fizz,49,Buzz," +
                                                "Fizz,52,53,Fizz,Buzz,56,Fizz,58,59,FizzBuzz," +
                                                "61,62,Fizz,64,Buzz,Fizz,67,68,Fizz,Buzz," +
                                                "71,Fizz,73,74,FizzBuzz,76,77,Fizz,79,Buzz," +
                                                "Fizz,82,83,Fizz,Buzz,86,Fizz,88,89,FizzBuzz," +
                                                "91,92,Fizz,94,Buzz,Fizz,97,98,Fizz,Buzz,";

    @Solution
    private FizzBuzz fizzBuzz;

    @Solve(order = 1, hint = "Use fizzBuzz.printNumbers to print numbers from 1 to 100, (separate two number with ',')")
    public void verify_1() {
        FizzBuzzPrinter printer = fizzBuzz.printNumbers();
        Assert.assertEquals(EXPECTED_1_100, printer.getWhatHasBeenPrinted());
    }

    @Solve(order = 2, hint = "Use fizzBuzz.printNumbersWithFizz to print \"Fizz\" instead of number which is divisible by 3")
    public void verify_2(){
        FizzBuzzPrinter printer = fizzBuzz.printNumbersWithFizz();
        Assert.assertEquals(EXPECTED_FIZZ, printer.getWhatHasBeenPrinted());
    }

    @Solve(order = 3, hint = "Use fizzBuzz.printNumbersWithBuzz to print \"Buzz\" instead of number which is divisible by 5")
    public void verify_3(){
        FizzBuzzPrinter printer = fizzBuzz.printNumbersWithBuzz();
        Assert.assertEquals(EXPECTED_BUZZ, printer.getWhatHasBeenPrinted());
    }

    @Solve(order = 4, hint = "Use fizzBuzz.printNumbersWitFizzhBuzz to print \"FizzBuzz\" instead of number which is divisible by both 3 and 5")
    public void verify_4(){
        FizzBuzzPrinter printer = fizzBuzz.printNumbersWithFizzBuzz();
        Assert.assertEquals(EXPECTED_FIZZ_BUZZ, printer.getWhatHasBeenPrinted());
    }

    @Solve(order = 5, hint = "Implement getFizzBuzzOrNumber to verify supplied number within the range 1 to 100, test with 7 that return \"7\"")
    public void verify_5(){
        Assert.assertEquals("7",fizzBuzz.getFizzBuzzOrNumber(7));
    }

    @Solve(order = 6, hint = "Implement getFizzBuzzOrNumber to throw IllegalArgumentException if the number is outside 1 to 100, test with 101",
            expected = IllegalArgumentException.class)
    public void verify_6(){
        Assert.assertEquals("7",fizzBuzz.getFizzBuzzOrNumber(101));
    }

    @Solve(order = 7, hint = "Implement getFizzBuzzOrNumber to throw IllegalArgumentException if the number is outside 1 to 100, test with 0",
            expected = IllegalArgumentException.class)
    public void verify_7(){
        Assert.assertEquals("7",fizzBuzz.getFizzBuzzOrNumber(0));
    }

    @Solve(order = 8, hint = "Implement getFizzBuzzOrNumber to return result Fizz or Buzz or FizzBuzz per above criteria")
    public void verify_8(){
        Assert.assertEquals("Fizz",fizzBuzz.getFizzBuzzOrNumber(9));
        Assert.assertEquals("Buzz",fizzBuzz.getFizzBuzzOrNumber(10));
        Assert.assertEquals("FizzBuzz",fizzBuzz.getFizzBuzzOrNumber(15));
    }
}
