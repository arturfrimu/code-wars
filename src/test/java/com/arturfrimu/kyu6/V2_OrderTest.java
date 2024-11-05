package com.arturfrimu.kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Order class, which is designed to sort words in a string based on embedded numbers.
 * Each word in the input contains a number indicating its position in the sorted output.
 */
public class V2_OrderTest {
    public static String order(String words) {
        if (words.isBlank()) {
            return "";
        }

        String[] splitedWords = words.split(" ");

        int wordsCount = splitedWords.length;

        String[] finalWords = new String[wordsCount];

        for (String splitedWord : splitedWords) {
            char[] charArray = splitedWord.toCharArray();
            int digit = 1;
            for (Character c : charArray) {
                if (Character.isDigit(c)) {
                    int index = splitedWord.indexOf(c);
                    char c1 = splitedWord.charAt(index);
                    digit = Integer.parseInt(c1 + "") - 1;
                }
            }

            if (finalWords[digit] != null) {
                if (digit == 0) {
                    String existingValue = finalWords[digit];
                    finalWords[digit + 1] = existingValue;
                    finalWords[digit] = splitedWord;
                } else {
                    String existingValue = finalWords[digit];
                    finalWords[digit] = existingValue;
                    finalWords[digit - 1] = splitedWord;
                }
            } else {
                finalWords[digit] = splitedWord;
            }
        }

        return String.join(" ", finalWords);
    }

    @Test
    public void testBasicOrder() {
        assertEquals("Thi1s is2 3a T4est", order("is2 Thi1s T4est 3a"));
    }

    @Test
    public void testMixedOrder() {
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("", order(""));
    }

    @Test
    public void testSingleWord() {
        assertEquals("wor1d", order("wor1d"));
    }

    @Test
    public void testDuplicateNumbers() {
        assertEquals("wo1rd wor1d", order("wor1d wo1rd"));
    }
}

