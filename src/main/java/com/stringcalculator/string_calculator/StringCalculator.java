package com.stringcalculator.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        String delimiter = ",|\n";
        String numPart = numbers;


        if (numbers.startsWith("//")) {
            Matcher m = Pattern.compile("//(.*?)\\n(.*)").matcher(numbers);
            if (m.matches()) {
                delimiter = Pattern.quote(m.group(1));
                numPart = m.group(2);
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
            }
            sum += num;
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
