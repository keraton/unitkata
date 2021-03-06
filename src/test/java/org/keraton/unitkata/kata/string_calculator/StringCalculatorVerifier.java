package org.keraton.unitkata.kata.string_calculator;

import org.junit.Assert;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

import java.lang.reflect.Method;

public class StringCalculatorVerifier {

    @Solution
    private StringCalculator stringCalculator;

    @Solve(order = 1, hint = "Create a simple String calculator with a method : Integer add(String numbers)")
    public void verifier_1() throws NoSuchMethodException {
        Method method = stringCalculator.getClass().getDeclaredMethod("add", String.class);
        Assert.assertEquals(Integer.class, method.getReturnType());
    }

    @Solve(order = 2, hint = "The method can take empty string and it will return 0")
    public void verifier_2() {
        Assert.assertEquals(Integer.valueOf(0), stringCalculator.add(""));
    }

    @Solve(order = 3, hint = "The method can take 1 number and return it value, for example “1” return 1 ")
    public void verifier_3() {
        Assert.assertEquals(Integer.valueOf(1), stringCalculator.add("1"));
    }

    @Solve(order = 4, hint = "The method can take 1 number and return it value, for example “n” return n ")
    public void verifier_3bis() {
        Assert.assertEquals(Integer.valueOf(1), stringCalculator.add("1"));
        Assert.assertEquals(Integer.valueOf(5), stringCalculator.add("5"));
        Assert.assertEquals(Integer.valueOf(10), stringCalculator.add("10"));
        Assert.assertEquals(Integer.valueOf(15), stringCalculator.add("15"));
    }

    @Solve(order = 5, hint = "The method can take 2 numbers delimit by ',' and return it sums, for example “1,2” return 3 ")
    public void verifier_4() {
        Assert.assertEquals(Integer.valueOf(3), stringCalculator.add("1,2"));
    }

    @Solve(order = 6, hint = "The method can take n number delimit by ',' and return it sums, for example “1,2,..,n” return Sum(1,..,n) ")
    public void verifier_5() {
        Assert.assertEquals(Integer.valueOf(15), stringCalculator.add("1,2,3,4,5"));
    }

    @Solve(order = 7, hint = "Allow the Add method to handle new lines between numbers (instead of commas). " +
                              "the following input is ok:  “1\\n2,3”  (will equal 6) ")
    public void verifier_6() {
        Assert.assertEquals(Integer.valueOf(6), stringCalculator.add("1\n2,3"));
    }

    @Solve(order = 8, hint = "To change a delimiter: prefix “//[delimiter]\\n[numbers…]” for example “//;\\n1;2” " +
                             "should return 3 where the default delimiter is ‘;’ .")
    public void verifier_8() {
        Assert.assertEquals(Integer.valueOf(3), stringCalculator.add("//;\n1;2"));
    }

    @Solve(order = 9, hint = "Calling Add with a negative number will throw an exception “negatives not allowed” - " +
                             "and the negative that was passed, ex add(-1,2,-2) -> negatives not allowed:-1,-2 ")
    public void verifier_9() {
        try {
            stringCalculator.add("-1,2,-2");
            Assert.fail("Should launch exception IllegalArgumentException:negatives not allowed:-1,-2");
        }
        catch (IllegalArgumentException e){
            Assert.assertEquals("negatives not allowed:-1,-2",e.getMessage());
        }
    }

    @Solve(order = 10, hint = "(BONUS) Numbers bigger than 1000 should be ignored, so adding add(2,1001)  = 2")
    public void verifier_10() {
        Assert.assertEquals(Integer.valueOf(2), stringCalculator.add("2,1001"));
    }

    @Solve(order = 11, hint = "(BONUS) Delimiters can be of any length with the following format:  “//[delimiter]\\n” " +
                               "for example: “//[***]\\n1***2***3” should return 6")
    public void verifier_11() {
        Assert.assertEquals(Integer.valueOf(6), stringCalculator.add("//[***]\n1***2***3"));
    }

    @Solve(order = 12, hint = "(BONUS) Allow multiple delimiters like this:  “//[delim1][delim2]\\n” for example “//[*][%]\\n1*2%3” " +
                              "should return 6.")
    public void verifier_12() {
        Assert.assertEquals(Integer.valueOf(6), stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Solve(order = 14, hint = "(BONUS) Make sure you can also handle multiple delimiters with length longer than one char")
    public void verifier_13() {
        Assert.assertEquals(Integer.valueOf(6), stringCalculator.add("//[**][%%]\n1**2%%3"));
    }

}
