package org.keraton.unitkata.kata.roman;

public class RomanSolution {

    public int romanToInt(String s) {
        int result =  0;
        for (int i=0; i<s.length(); i++) {
            int charValue = actualCharToInt(s, i);
            if (nextCharIsBiggerThanActual(s, i, charValue))
                result = resultToSubstractTheNextValue(result, charValue);
            else
                result = resultIsAddedToNextValue(result, charValue);
        }
        return result;
    }

    private int resultIsAddedToNextValue(int result, int charValue) {
        result += charValue;
        return result;
    }

    private int resultToSubstractTheNextValue(int result, int charValue) {
        result -= charValue;
        return result;
    }

    private int actualCharToInt(String s, int i) {
        char c = s.charAt(i);
        return charToInt(c);
    }

    private boolean nextCharIsBiggerThanActual(String s, int i, int charValue) {
        return hasNext(s, i)
                && nextCharToInt(s, i) >charValue;
    }

    private boolean hasNext(String s, int i) {
        return i+1<s.length();
    }

    private int nextCharToInt(String s, int i) {
        return charToInt(s.charAt(i+1));
    }

    private int charToInt(char c) {
        int result = 0;
        if ('I' == c) result = 1;
        if ('V' == c) result = 5;
        if ('X' == c) result = 10;
        return result;
    }
}
