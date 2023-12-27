package kpy6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestValidParenthesesTest {
    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertEquals(2, LongestValidParentheses.validParentheses("()(()"));
        assertEquals(2, LongestValidParentheses.validParentheses("(()"));
        assertEquals(4, LongestValidParentheses.validParentheses(")()())"));
        assertEquals(0, LongestValidParentheses.validParentheses(""));
    }
}