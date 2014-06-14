package org.keraton.unitkata.kata.string_calculator;

import java.util.Iterator;

public class StringCalculator {

    private class NumberIterator  implements Iterator<String>{

        private final String string;
        private char defaultDelimiter;
        private int position;

        public NumberIterator(String string) {
            this.string = string;
        }

        public NumberIterator(String string, char delimiter) {
            this.string = string;
            this.defaultDelimiter = delimiter;
        }

        @Override
        public boolean hasNext() {
            return position < string.length();
        }

        @Override
        public String next() {
            String next = "";
            while (hasNext()) {
                if (hasChar(',')) break;
                if (hasChar('\n')) break;
                if (hasChar(defaultDelimiter)) break;
                next += string.charAt(position);
                position++;
            }

            return next;
        }

        private boolean hasChar(char toVerify) {
            if (toVerify == string.charAt(position)) {
                position++;
                return true;
            }
            return false;
        }

        @Override
        public void remove() {
        }
    }

    public Integer add(String string){
        if(string.isEmpty()) return 0;
        return countNumberAndVerifyNegatives(getNumberIterator(string));
    }

    private Integer countNumberAndVerifyNegatives(NumberIterator numberIterator) {
        int count = 0;
        String messageError = "";
        while(numberIterator.hasNext()) {
            int toCount = Integer.valueOf(numberIterator.next());
            messageError = verifyNegatives(messageError, toCount);
            count += toCount;
        }
        if(isContainNegatives(messageError))
            throw new IllegalArgumentException("negatives not allowed:"+messageError);

        return count;
    }

    private boolean isContainNegatives(String messageError) {
        return !messageError.isEmpty();
    }

    private String verifyNegatives(String messageError, int toCount) {
        if (toCount<0) {
            if (!messageError.isEmpty())
                messageError += ",";
            messageError += toCount;
        }
        return messageError;
    }

    private NumberIterator getNumberIterator(String string) {
        NumberIterator numberIterator = new NumberIterator(string);
        if(string.startsWith("//") && string.indexOf("\n") == 3) {
            char delimiter =  string.charAt(2);
            numberIterator = new NumberIterator(string.substring(4), delimiter);
        }
        return numberIterator;
    }
}
