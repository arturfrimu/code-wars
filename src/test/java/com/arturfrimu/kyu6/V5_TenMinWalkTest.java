package com.arturfrimu.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class for the TenMinWalk problem.
 * Verifies if a generated walk will last exactly ten minutes and return to the starting point.
 */
public class V5_TenMinWalkTest {

    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;

        Map<Character, List<Character>> result = new String(walk)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c));

        var n = size(result.get('n'));
        var s = size(result.get('s'));
        var e = size(result.get('e'));
        var w = size(result.get('w'));
        return n.equals(s) && e.equals(w);
    }

    private static Integer size(List<Character> value) {
        return ofNullable(value).map(List::size).orElse(0);
    }

    private static void doTest(char[] input, boolean expected) {
        String message = "for input = " + Arrays.toString(input);
        boolean actual = V5_TenMinWalkTest.isValid(input);
        assertEquals(expected, actual, message);
    }

//    @Test
//    void falsea() {
//        doTest(new char[]{'n', 's', 'e', 'w'}, false);
//    }

    @Test
    void falseWalkTooShort() {
        doTest(new char[]{'n'}, false);
        doTest(new char[]{'n', 's'}, false);
    }

    @Test
    void falseWalkTooLong() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}, false);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'}, false);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'}, false);
    }

    @Test
    void falseDoesNotLoopBackToStart() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 'n'}, false);
        doTest(new char[]{'e', 'e', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'}, false);
        doTest(new char[]{'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e'}, false);
        doTest(new char[]{'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w'}, false);
        doTest(new char[]{'s', 'e', 's', 'e', 's', 'e', 's', 'e', 's', 'e'}, false);
        doTest(new char[]{'s', 'w', 's', 'w', 's', 'w', 's', 'w', 's', 'w'}, false);
    }

    @Test
    void trueIsValid10MinutesWalk() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}, true);
        doTest(new char[]{'e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'}, true);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'}, true);
    }
}

