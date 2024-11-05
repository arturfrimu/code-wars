package com.arturfrimu.kyu8;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Test class for finding the smallest integer in an array.
 * The function being tested should return the smallest integer from the given array of integers.
 */
public class V6_SmallestIntegerFinderTest {

    @Test
    public void testBasicExamples() {
        assertEquals(2, findSmallestInt(new int[]{34, 15, 88, 2}));
        assertEquals(-345, findSmallestInt(new int[]{34, -345, -1, 100}));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-10, findSmallestInt(new int[]{-10, -3, -1}));
        assertEquals(-1000, findSmallestInt(new int[]{0, -1000, -999}));
    }

    @Test
    public void testMixedNumbers() {
        assertEquals(-50, findSmallestInt(new int[]{100, -50, 0, 1}));
        assertEquals(1, findSmallestInt(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testSingleElementArray() {
        assertEquals(42, findSmallestInt(new int[]{42}));
    }

    @Test
    public void testAllSameNumbers() {
        assertEquals(5, findSmallestInt(new int[]{5, 5, 5, 5}));
    }

    // TODO Implement your logic here
    public int findSmallestInt(int[] numbers) {
        return IntStream.of(numbers).boxed().min(Comparator.comparingInt(a -> a)).get();
    }
}

