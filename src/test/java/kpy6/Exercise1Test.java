package kpy6;

import kpy6.Exercise1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    @Test
    public void test() {
        assertEquals(23, new Exercise1().solution(10));
    }
}