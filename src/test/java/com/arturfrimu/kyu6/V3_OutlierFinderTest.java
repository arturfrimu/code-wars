package com.arturfrimu.kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for OutlierFinder class, which is designed to find the single integer (outlier) in an array
 * that differs in parity from the rest (either the only even or the only odd number).
 */
public class V3_OutlierFinderTest {

    public static int findOutlier(int[] integers) {
        List<Integer> odds = Arrays.stream(integers).boxed().filter(num -> num % 2 == 0).toList();

        if (odds.size() == 1) {
            return odds.get(0);
        } else {
            return Arrays.stream(integers).boxed().filter(num -> num % 2 != 0).findFirst().get();
        }
    }

    @Test
    public void testOddOutlier() {
        assertEquals(11, findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
    }

    @Test
    public void testEvenOutlier() {
        assertEquals(160, findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }

    @Test
    public void testSingleOddOutlierInEvenArray() {
        assertEquals(3, findOutlier(new int[]{10, 22, 30, 14, 18, 3, 24}));
    }

    @Test
    public void testSingleEvenOutlierInOddArray() {
        assertEquals(8, findOutlier(new int[]{1, 3, 5, 7, 8, 9, 11}));
    }

    @Test
    public void testNegativeOddOutlier() {
        assertEquals(-7, findOutlier(new int[]{-6, -4, -8, -12, -14, -7}));
    }

    @Test
    public void testNegativeEvenOutlier() {
        assertEquals(-10, findOutlier(new int[]{-3, -7, -5, -9, -11, -13, -10}));
    }

    @Test
    public void testFixedOutlier17() {
        assertEquals(17, findOutlier(new int[]{6, 8, 10, 12, 14, 16, 17}));
    }

    @Test
    public void testFixedNegativeOutlierMinus59() {
        assertEquals(-59, findOutlier(new int[]{46, 48, -59, 50, 52, 54}));
    }

    @Test
    public void testLargeEvenOutlier() {
        assertEquals(1024, findOutlier(new int[]{-59, -61, -63, 1024, -65, -67, -69}));
    }

    @Test
    public void testLargeOddOutlier() {
        assertEquals(-12345, findOutlier(new int[]{2468, 1234, 5678, -12345, 8900, 2460, 1350}));
    }
}

