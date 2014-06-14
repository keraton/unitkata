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

    @Solve(order = 4, hint = "The method can take 2 number and return it sums, for example “1,2” return 3 ")
    public void verifier_4() {
        Assert.assertEquals(Integer.valueOf(3), stringCalculator.add("1,2"));
    }

    @Solve(order = 5, hint = "The method can take n number and return it sums, for example “1,2,..,n” return Sum(1,..,n) ")
    public void verifier_5() {
        Assert.assertEquals(Integer.valueOf(15), stringCalculator.add("1,2,3,4,5"));
    }

    @Solve(order = 6, hint = "Allow the Add method to handle new lines between numbers (instead of commas). the following input is ok:  “1\\n2,3”  (will equal 6) ")
    public void verifier_6() {
        Assert.assertEquals(Integer.valueOf(6), stringCalculator.add("1\n2,3"));
    }

    @Solve(order = 7, hint = "The following input is NOT ok:  “1,\\n”, expected NumberFormatException.class",
           expected = NumberFormatException.class
            )
    public void verifier_7() {
        Assert.assertEquals(Integer.valueOf(6), stringCalculator.add("1,\n"));
    }

    @Solve(order = 8, hint = "To change a delimiter: prefix “//[delimiter]\\n[numbers…]” for example “//;\\n1;2” should return 3 where the default delimiter is ‘;’ .")
    public void verifier_8() {
        Assert.assertEquals(Integer.valueOf(3), stringCalculator.add("//;\n1;2"));
    }

    @Solve(order = 9, hint = "Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed, ex add(-1,2,-2) -> -1,-2 ")
    public void verifier_9() {
        try {
            stringCalculator.add("-1,2,-2");
            Assert.fail("Should launch exception IllegalArgumentException:negatives not allowed:-1,-2");
        }
        catch (IllegalArgumentException e){
            Assert.assertEquals("negatives not allowed:-1,-2",e.getMessage());
        }
    }
}
