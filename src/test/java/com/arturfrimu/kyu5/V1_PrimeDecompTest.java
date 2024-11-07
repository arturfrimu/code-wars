package com.arturfrimu.kyu5;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for verifying the prime factor decomposition of a number in the required string format.
 * The factors method calculates the prime factors of a number and formats them accordingly.
 */
public class V1_PrimeDecompTest {

    public static String factors(int n) {
        StringBuilder result = new StringBuilder();
        int divisor = 2;

        while (n > 1) {
            int count = 0;
            while (n % divisor == 0) {
                n /= divisor;
                count++;
            }
            if (count > 0) {
                result.append("(").append(divisor);
                if (count > 1) {
                    result.append("**").append(count);
                }
                result.append(")");
            }
            divisor++;
        }

        return result.toString();
    }

    @Test
    public void testPrimeDecompExample() {
        int input = 86240;
        String expected = "(2**5)(5)(7**2)(11)";
        assertEquals(expected, factors(input));
    }

    @Test
    public void testPrimeDecompOne() {
        int input = 7775460;
        String expected = "(2**2)(3**3)(5)(7)(11**2)(17)";
        assertEquals(expected, factors(input));
    }

    static Stream<Arguments> primeDecompTestData() {
        return Stream.of(
                Arguments.of(60, "(2**2)(3)(5)"),
                Arguments.of(100, "(2**2)(5**2)"),
                Arguments.of(13, "(13)"),
                Arguments.of(945, "(3**3)(5)(7)"),
                Arguments.of(1024, "(2**10)")
        );
    }

    @ParameterizedTest
    @MethodSource("primeDecompTestData")
    void testPrimeDecompAdditional(int input, String expected) {
        assertEquals(expected, factors(input));
    }
}

