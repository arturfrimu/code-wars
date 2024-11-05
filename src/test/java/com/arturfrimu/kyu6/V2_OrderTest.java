package com.arturfrimu.kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

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

        Map<Integer, Stack<String>> linkedHashMap = new TreeMap<>();

        Arrays.stream(splitedWords)
                .forEach(splitedWord -> {
                    int wordPosition = splitedWord.toLowerCase()
                                               .chars()
                                               .boxed()
                                               .filter(Character::isDigit)
                                               .distinct()
                                               .findFirst()
                                               .map(Character::getNumericValue)
                                               .get();

                    if (linkedHashMap.containsKey(wordPosition)) {
                        linkedHashMap.get(wordPosition).push(splitedWord);
                    } else {
                        Stack<String> objects = new Stack<>();
                        objects.push(splitedWord);
                        linkedHashMap.put(wordPosition, objects);
                    }
                });

        String result = "";
        for (Map.Entry<Integer, Stack<String>> entry : linkedHashMap.entrySet()) {
            Stack<String> stack = entry.getValue();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                result = result + " " + stack.pop();
            }
        }

        return result.trim();
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

