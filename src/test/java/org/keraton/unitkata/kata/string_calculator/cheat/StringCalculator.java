package org.keraton.unitkata.kata.string_calculator.cheat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringCalculator {

    private class NumberIterator  implements Iterator<String>{

        private final String string;
        private char defaultDelimiter;
        private int position = 0;
        private List<String> delimiters;

        public NumberIterator(String string) {
            this.string = string;
        }

        public NumberIterator(String string, char delimiter) {
            this.string = string;
            this.defaultDelimiter = delimiter;
        }

        public NumberIterator(String string, List<String> delimiters) {
            this.string = string;
            this.delimiters = delimiters;
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
                if (hasString()) break;
                next += string.charAt(position);
                position++;
            }

            return next;
        }

        private boolean hasString() {
            if (delimiters == null) return false;
            for(String delimeter : delimiters) {
                if (string.substring(position).startsWith(delimeter)) {
                    position += delimeter.length();
                    return true;
                }
            }
            return false;
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
            int toCount = getInteger(numberIterator);
            messageError = verifyNegatives(messageError, toCount);
            count += toCount;
        }
        if(isContainNegatives(messageError))
            throw new IllegalArgumentException("negatives not allowed:"+messageError);

        return count;
    }

    private Integer getInteger(NumberIterator numberIterator) {
        Integer value = Integer.valueOf(numberIterator.next());
        if(value>1000)
            return 0;
        return value;
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
        if(string.startsWith("//")) {
            if (string.indexOf("\n") == 3) {
                char delimiter = string.charAt(2);
                numberIterator = new NumberIterator(string.substring(4), delimiter);
            }
            else {
                String delimeters = string.substring("//".length(), string.indexOf("\n"));
                List<String> listDelimeters = extractDelimeter(delimeters);
                numberIterator = new NumberIterator(string.substring(string.indexOf("\n")+1), listDelimeters);
            }
        }


        return numberIterator;
    }

    private List<String> extractDelimeter(String delimeters) {
        String temp = null;
        List<String> listDelimeters = new ArrayList<String>();
        for (int i=0; i<delimeters.length(); i++){
            char character = delimeters.charAt(i);
            if (character == '[') {
                temp = "";
            }
            else if (character == ']' && temp != null) {
                listDelimeters.add(temp);
            }
            else if (temp != null) {
                temp += character;
            }
            else {
                throw new IllegalArgumentException("Incorrect delimeter");
            }
        }
        return listDelimeters;
    }
}
