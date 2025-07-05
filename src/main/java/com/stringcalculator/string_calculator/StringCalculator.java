package com.stringcalculator.string_calculator;

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

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;

    }


}
