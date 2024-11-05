package com.arturfrimu.kyu8;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the Trilingual Democracy function.
 * This function determines the language that a group of three people will use based on their native languages.
 * The input is a string of three characters representing the languages, and the output is the language to be used.
 * The languages are encoded as D (Deutsch), F (Français), I (Italiano), and K (Rumantsch).
 */
public class V4_TrilingualDemocracyTest {

    private static final Set<Character> possibleLanguages = Set.of('F', 'K', 'I', 'D');

    @Test
    public void testExamples() {
        test("FFF", 'F');
        test("IIK", 'K');
        test("DFK", 'I');
        test("DDI", 'I');
        test("DIK", 'F'); // All three different, so remaining is 'F'
    }

    static void test(String group, char want) {
        assertEquals(want, trilingualDemocracy(group.toCharArray()), group);
        assertEquals(want, trilingualDemocracyV2(group.toCharArray()), group);
    }

    public static char trilingualDemocracy(char[] group) {
        Map<Character, Byte> map = new String(group)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> (byte) 1,
                        (existing, replacement) -> (byte) (existing + 1)
                ));

        if (map.size() == group.length) {
            Set<Character> difference = new HashSet<>(possibleLanguages);
            difference.removeAll(map.keySet());
            return difference.stream().findFirst().orElseThrow();
        }

        return map.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow().getKey();
    }

    public static char trilingualDemocracyV2(char[] group){
        return (char)(group[0] ^ group[1] ^ group[2]);
    }
}
