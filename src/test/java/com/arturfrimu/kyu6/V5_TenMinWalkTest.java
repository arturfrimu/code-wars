package com.arturfrimu.kyu6;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class for the TenMinWalk problem.
 * Verifies if a generated walk will last exactly ten minutes and return to the starting point.
 */
public class V5_TenMinWalkTest {

    // Method to test the walk's validity (Placeholder for logic implementation)
    public static boolean isValid(char[] walk) {
        // TODO implement your logic here
        return true;
    }

    private static void doTest(char[] input, boolean expected) {
        String message = "for input = " + Arrays.toString(input);
        boolean actual = V5_TenMinWalkTest.isValid(input);
        assertEquals(expected, actual, message);
    }

    @Test
    void falseWalkTooShort() {
        doTest(new char[] {'n'}, false);
        doTest(new char[] {'n', 's'}, false);
    }

    @Test
    void falseWalkTooLong() {
        doTest(new char[] {'n','s','n','s','n','s','n','s','n','s','n','s'}, false);
        doTest(new char[] {'n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w'}, false);
        doTest(new char[] {'n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w'}, false);
    }

    @Test
    void falseDoesNotLoopBackToStart() {
        doTest(new char[] {'n','s','n','s','n','s','n','s','n','n'}, false);
        doTest(new char[] {'e','e','e','w','n','s','n','s','e','w'}, false);
        doTest(new char[] {'n','e','n','e','n','e','n','e','n','e'}, false);
        doTest(new char[] {'n','w','n','w','n','w','n','w','n','w'}, false);
        doTest(new char[] {'s','e','s','e','s','e','s','e','s','e'}, false);
        doTest(new char[] {'s','w','s','w','s','w','s','w','s','w'}, false);
    }

    @Test
    void trueIsValid10MinutesWalk() {
        doTest(new char[] {'n','s','n','s','n','s','n','s','n','s'}, true);
        doTest(new char[] {'e','w','e','w','n','s','n','s','e','w'}, true);
        doTest(new char[] {'n','s','e','w','n','s','e','w','n','s'}, true);
    }
}

