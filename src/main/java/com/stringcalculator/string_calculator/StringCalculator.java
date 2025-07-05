package com.stringcalculator.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String delimiter = ",|\n";
        String numPart = numbers;

        // Handle custom delimiters
        if (numbers.startsWith("//")) {
            String header = numbers.substring(2, numbers.indexOf("\n"));
            numPart = numbers.substring(numbers.indexOf("\n") + 1);

            if (header.startsWith("[")) {

                List<String> delimiters = new ArrayList<>();
                Matcher inner = Pattern.compile("\\[(.*?)]").matcher(header);
                while (inner.find()) {
                    delimiters.add(Pattern.quote(inner.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {

                delimiter = Pattern.quote(header);
            }
        }

        String[] tokens = numPart.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            int num = Integer.parseInt(token);
            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            String msg = "negative numbers not allowed " +
                    String.join(",", negativeNumbers.stream()
                            .map(String::valueOf)
                            .toArray(String[]::new));
            throw new IllegalArgumentException(msg);
        }

        return sum;
    }
}
