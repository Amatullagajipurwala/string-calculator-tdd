package com.stringcalculator.string_calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    void shouldReturnZeroForEmptyString() {
        assertEquals(0, new StringCalculator().add(""));
    }
    @Test
    void shouldReturnNumberWhenSingleNumber() {
        assertEquals(1, new StringCalculator().add("1"));
    }
    @Test
    void shouldReturnSumOfTwoCommaSeparatedNumbers() {
        assertEquals(6, new StringCalculator().add("1,5"));
    }


}
