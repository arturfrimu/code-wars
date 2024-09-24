package com.arturfrimu.kyu8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the Welcome greeting function.
 * The method being tested should return a greeting based on the provided language code.
 * If the language is not recognized or the input is invalid, it should handle those cases appropriately.
 */
public class V2_SolutionTest {

    private static Map<String, String> greetings;

    static {
        greetings = new HashMap<>();
        greetings.put("english", "Welcome");
        greetings.put("czech", "Vitejte");
        greetings.put("danish", "Velkomst");
        greetings.put("dutch", "Welkom");
        greetings.put("estonian", "Tere tulemast");
        greetings.put("finnish", "Tervetuloa");
        greetings.put("flemish", "Welgekomen");
        greetings.put("french", "Bienvenue");
        greetings.put("german", "Willkommen");
        greetings.put("irish", "Failte");
        greetings.put("italian", "Benvenuto");
        greetings.put("latvian", "Gaidits");
        greetings.put("lithuanian", "Laukiamas");
        greetings.put("polish", "Witamy");
        greetings.put("spanish", "Bienvenido");
        greetings.put("swedish", "Valkommen");
        greetings.put("welsh", "Croeso");
    }

    @Test
    public void testValidLanguages() {
        assertEquals("Welcome", greet("english"));
        assertEquals("Vitejte", greet("czech"));
        assertEquals("Velkomst", greet("danish"));
        assertEquals("Welkom", greet("dutch"));
        assertEquals("Bienvenido", greet("spanish"));
    }

    @Test
    public void testInvalidLanguages() {
        assertEquals("Welcome", greet("IP_ADDRESS_INVALID"));
        assertEquals("Welcome", greet("IP_ADDRESS_NOT_FOUND"));
        assertEquals("Welcome", greet("IP_ADDRESS_REQUIRED"));
    }

    @Test
    public void testUnknownLanguage() {
        assertEquals("Welcome", greet("unknown_language"));
    }

    public String greet(String language) {
        return greetings.getOrDefault(language, greetings.get("english"));
    }
}
