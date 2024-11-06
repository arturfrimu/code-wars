package com.arturfrimu.kyu6;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for verifying the multiplicative persistence calculation for a given number.
 * The persistence method calculates the number of steps required to reduce the number to a single digit
 * by multiplying its digits iteratively.
 */
public class V4_PersistenceTest {

    public int persistence(long num) {
        if (num < 10) {
            return 0;
        }
        AtomicInteger counter = new AtomicInteger(0);

        List<Integer> numberToList = getNumberToList(num);
        Integer total = multiplyAllNumbers(numberToList, counter);

        while (total >= 10) {
            numberToList = getNumberToList(total);
            total = multiplyAllNumbers(numberToList, counter);
        }
        return counter.get();
    }

    private static Integer multiplyAllNumbers(List<Integer> numberToList, AtomicInteger counter) {
        counter.incrementAndGet();
        return numberToList.stream().reduce((a, b) -> a * b).orElseThrow();
    }

    private static List<Integer> getNumberToList(long num) {
        return Arrays.stream(String.valueOf(num).split(""))
                .map(Integer::parseInt)
                .toList();
    }

    @Test
    public void basicTests() {
        assertEquals(3, persistence(39));
        assertEquals(4, persistence(999));
        assertEquals(0, persistence(4));
    }

    static Stream<Arguments> persistenceTestData() {
        return Stream.of(
                Arguments.of(25, 2),
                Arguments.of(444, 3),
                Arguments.of(77, 4),
                Arguments.of(888, 4),
                Arguments.of(10, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("persistenceTestData")
    void testPersistence(int input, int expected) {
        assertEquals(expected, persistence(input));
    }
}

