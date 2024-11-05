package com.arturfrimu.kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Order class, which is designed to sort words in a string based on embedded numbers.
 * Each word in the input contains a number indicating its position in the sorted output.
 */
public class V2_OrderTest {

    public static String orderV2(String words) {
        if (words.isBlank()) {
            return "";
        }

        return Optional.ofNullable(Arrays.stream(words.split(" "))
                .map(splitedWord -> {
                    int wordPosition = splitedWord.toLowerCase().chars().boxed()
                            .filter(Character::isDigit)
                            .distinct()
                            .findFirst()
                            .map(Character::getNumericValue)
                            .orElseThrow(() -> new RuntimeException("This word not contains a position : " + splitedWord));
                    return new PositionToWord(wordPosition, splitedWord);
                }).sorted(Comparator.comparing(PositionToWord::position))
                .map(el -> el.word)
                .collect(Collectors.joining(" "))).orElse("");
    }

    public static String orderV1(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> s.replaceAll("\\D+", "")))
                .collect(Collectors.joining(" "));
    }

    public record PositionToWord(int position, String word) {
    }

    @Test
    public void testBasicOrder() {
        assertEquals("Thi1s is2 3a T4est", orderV1("is2 Thi1s T4est 3a"));
    }

    @Test
    public void testMixedOrder() {
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", orderV1("4of Fo1r pe6ople g3ood th5e the2"));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("", orderV1(""));
    }

    @Test
    public void testSingleWord() {
        assertEquals("wor1d", orderV1("wor1d"));
    }

    @Test
    public void testDuplicateNumbers() {
        assertEquals("wo1rd wor1d", orderV1("wo1rd wor1d"));
    }
}

