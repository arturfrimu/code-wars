package com.arturfrimu.kyu6;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

public class V6_EnoughIsEnough {

    public static int[] deleteNthV2(int[] elements, int maxOccurrences) {
        Map<Integer, AtomicInteger> initialMap = Arrays.stream(elements).boxed()
                .collect(Collectors.toMap(Function.identity(), (v) -> new AtomicInteger(maxOccurrences), (k1, k2) -> k1));

        List<Integer> finalResult = new ArrayList<>();

        for (int element : elements) {
            if (initialMap.get(element).decrementAndGet() >= 0) {
                finalResult.add(element);
            }
        }

        return finalResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] deleteNthV1(int[] elements, int maxOccurrences) {
        Map<Integer, AtomicInteger> occurrenceCounter = new HashMap<>();

        return Arrays.stream(elements)
                .filter(element -> occurrenceCounter
                                           .computeIfAbsent(element, k -> new AtomicInteger(maxOccurrences))
                                           .getAndDecrement() > 0
                )
                .toArray();
    }


    @Test
    public void deleteNth() {
        assertArrayEquals(
                new int[]{20},
                deleteNthV1(new int[]{20, 20, 20, 20}, 1)
        );
        assertArrayEquals(
                new int[]{20, 37, 21},
                deleteNthV1(new int[]{20, 37, 20, 21}, 1)
        );
        assertArrayEquals(
                new int[]{1, 1, 3, 3, 7, 2, 2, 2},
                deleteNthV1(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)
        );
        assertArrayEquals(
                new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5},
                deleteNthV1(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)
        );
        assertArrayEquals(
                new int[]{1, 1, 1, 1, 1},
                deleteNthV1(new int[]{1, 1, 1, 1, 1}, 5)
        );
        assertArrayEquals(
                new int[]{},
                deleteNthV1(new int[]{}, 5)
        );
    }
}