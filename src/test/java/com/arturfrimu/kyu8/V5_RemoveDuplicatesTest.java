package com.arturfrimu.kyu8;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test class for removing duplicates from a list of non-negative numbers.
 * The function being tested should remove duplicates while preserving the order of elements.
 */
public class V5_RemoveDuplicatesTest {

    @Test
    public void testBasicExamples() {
        assertArrayEquals(new int[]{1, 2}, removeDuplicates(new int[]{1, 1, 2}));
        assertArrayEquals(new int[]{1, 2, 3}, removeDuplicates(new int[]{1, 2, 1, 1, 3, 2}));
    }

    @Test
    public void testWithAllUniqueElements() {
        assertArrayEquals(new int[]{1, 2, 3}, removeDuplicates(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{5, 6, 7}, removeDuplicates(new int[]{5, 6, 7}));
    }

    @Test
    public void testWithAllDuplicateElements() {
        assertArrayEquals(new int[]{9}, removeDuplicates(new int[]{9, 9, 9, 9}));
    }

    @Test
    public void testEmptyList() {
        assertArrayEquals(new int[]{}, removeDuplicates(new int[]{}));
    }

    @Test
    public void testSingleElementList() {
        assertArrayEquals(new int[]{4}, removeDuplicates(new int[]{4}));
    }

    public int[] removeDuplicates(int[] array) {
        Set<Integer> distinctSet = IntStream.of(array).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        return distinctSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] removeDuplicatesV2(int[] array) {
        return IntStream.of(array).distinct().toArray();
    }
}

