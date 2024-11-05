package com.arturfrimu.kyu8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the terminal game move function.
 * The function being tested should calculate the new position of the hero based on the current position and the dice roll.
 * The hero moves twice the value of the dice roll forward.
 */
public class V3_MoveTest {

    @Test
    public void basicTests() {
        assertEquals(8, move(0, 4));
        assertEquals(15, move(3, 6));
        assertEquals(12, move(2, 5));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals(0, move(0, 0));
        assertEquals(2, move(0, 1));
        assertEquals(100, move(50, 25));
    }

    public int move(int position, int roll) {
        return position + (roll * 2);
    }
}

