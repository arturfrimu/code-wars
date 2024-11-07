package com.arturfrimu.kyu5;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for verifying the prime factor decomposition of a number in the required string format.
 * The factors method calculates the prime factors of a number and formats them accordingly.
 */
public class V1_PrimeDecompTest {

    public static String factors(int n) {
        var primeNumbers = findPrimeNumbersToN(n);
        Map<Integer, AtomicInteger> finalResults = new LinkedHashMap<>();

        for (var prime : primeNumbers) {
            var nCopy = n;
            while (nCopy % prime == 0) {
                finalResults.put(prime, new AtomicInteger(Optional.ofNullable(finalResults.get(prime)).orElse(new AtomicInteger(0)).incrementAndGet()));
                nCopy = nCopy / prime;
            }
        }

        if (finalResults.isEmpty()) {
            finalResults.put(n, new AtomicInteger(1));
        }

        // TODO Implement your logic here
        return finalResults.entrySet().stream().map(entry -> {
            var sb = new StringBuilder("(").append(entry.getKey());
            if (entry.getValue().get() > 1) {
                sb.append("**").append(entry.getValue());
            }
            return sb.append(")").toString();
        }).collect(Collectors.joining(""));
    }

    private static int[] findPrimeNumbersToN(int n) {
        return IntStream.range(2, n).filter(V1_PrimeDecompTest::isPrime).toArray();
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .allMatch(divisor -> number % divisor != 0);
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

