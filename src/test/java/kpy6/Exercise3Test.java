package kpy6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise3Test {

    @Test
    public void testSum1() {
        int[] numbers = {6, 2, 1, 8, 10};
        assertEquals(16, Exercise3.sum(numbers));
    }

    @Test
    public void testSum2() {
        int[] numbers = {1, 1, 11, 2, 3};
        assertEquals(6, Exercise3.sum(numbers));
    }
}