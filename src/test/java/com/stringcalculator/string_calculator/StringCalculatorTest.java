package com.stringcalculator.string_calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    void shouldReturnSumOfMultipleNumbers() {
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
    }

    @Test
    void shouldSupportNewlineAsDelimiter() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
    }
    @Test
    void shouldSupportCustomDelimiter() {
        assertEquals(13, new StringCalculator().add("//;\n1;2;10"));
    }
    @Test
    void shouldThrowOnNegativeNumbers() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new StringCalculator().add("1,-2,-3"));

        assertEquals("negative numbers not allowed -2,-3", ex.getMessage());
    }



}
