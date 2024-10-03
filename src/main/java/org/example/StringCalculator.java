package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            String customDelimiterPart = numbers.substring(2, delimiterEndIndex);
            delimiter = parseCustomDelimiters(customDelimiterPart);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] numArray = numbers.split(delimiter);
        return calculateSum(numArray);
    }

    private String parseCustomDelimiters(String customDelimiterPart) {
        if (customDelimiterPart.startsWith("[")) {
            List<String> delimiters = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(customDelimiterPart);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }
            return String.join("|", delimiters);
        }
        return Pattern.quote(customDelimiterPart);
    }

    private int calculateSum(String[] numArray) {
        List<String> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String num : numArray) {
            num = num.trim();
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    negativeNumbers.add(num);
                } else if (number <= 1000) {
                    sum += number;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + String.join(", ", negativeNumbers));
        }

        return sum;
    }
}



