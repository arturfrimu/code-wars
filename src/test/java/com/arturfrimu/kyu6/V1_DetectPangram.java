package com.arturfrimu.kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test class for checking if a given sentence is a pangram.
 * A pangram contains every letter of the alphabet at least once, case-insensitive.
 */
public class V1_DetectPangram {

    /**
     * Checks if the provided sentence is a pangram.
     *
     * @param sentence the sentence to be checked
     * @return true if the sentence is a pangram, false otherwise
     */
    public boolean isPangramV1(String sentence) {
        return sentence.toLowerCase().chars()
                       .filter(Character::isLetter)
                       .distinct()
                       .count() == 26;
    }

    public boolean isPangramV2(String sentence) {
        return "abcdefghijklmnopqrstuvwxyz".chars()
                .allMatch(c -> sentence.toLowerCase().indexOf(c) != -1);
    }

    @Test
    public void testValidPangrams() {
        List<String> pangrams = Arrays.asList(
                "The quick brown fox jumps over the lazy dog.",
                "Pack my box with five dozen liquor jugs.",
                "The five boxing wizards jump quickly."
        );
        for (String sentence : pangrams) {
            assertEquals(true, isPangramV1(sentence));
        }
    }

    @Test
    public void testInvalidPangrams() {
        List<String> nonPangrams = Arrays.asList(
                "Hello World!",
                "You shall not pass!",
                "Java programming language"
        );
        for (String sentence : nonPangrams) {
            assertEquals(false, isPangramV1(sentence));
        }
    }

    @Test
    public void testMixedCaseAndSymbols() {
        List<String> pangramsWithSymbols = Arrays.asList(
                "Sphinx of black quartz, judge my vow!",
                "Mr. Jock, TV quiz PhD, bags few lynx."
        );
        for (String sentence : pangramsWithSymbols) {
            assertEquals(true, isPangramV1(sentence));
        }
    }

    @Test
    public void testEmptyString() {
        assertEquals(false, isPangramV1(""));
    }

    @Test
    public void testShortString() {
        assertEquals(false, isPangramV1("a quick movement"));
    }
}
