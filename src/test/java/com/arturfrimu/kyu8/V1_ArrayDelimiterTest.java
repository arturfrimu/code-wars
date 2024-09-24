package com.arturfrimu.kyu8;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Printing Array elements with Comma delimiters
 * Input: Array of elements
 * ["h","o","l","a"]
 * Output: String with comma delimited elements of the array in th same order.
 * "h,o,l,a"
 */
public class V1_ArrayDelimiterTest {

    public static String printArray(Object[] array) {
        return Stream.of(array)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    @Test
    public void testStringArray() {
        String[] input = {"h", "o", "l", "a"};
        String expected = "h,o,l,a";
        assertEquals(expected, printArray(input));
    }

    @Test
    public void testEmptyArray() {
        String[] input = {};
        String expected = "";
        assertEquals(expected, printArray(input));
    }

    @Test
    public void testSingleElementArray() {
        String[] input = {"hello"};
        String expected = "hello";
        assertEquals(expected, printArray(input));
    }

    @Test
    @DisplayName("Test Integer")
    public void testInteger() {
        Integer[] array = new Integer[]{2, 4, 5, 2};
        assertEquals("2,4,5,2", printArray(array), "Testing with: [2, 4, 5, 2]");
    }
}
