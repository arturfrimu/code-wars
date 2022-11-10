package kpy6.ValidBraces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BraceCheckerTest {

    //"   (){}[]"   =>  True
    //"   ([{}])"   =>  True
    //"   (}"       =>  False
    //"   [(])"     =>  False
    //"   [({})](]" =>  False

    private BraceChecker checker = new BraceChecker();

    @Test
    public void testValid() {
//        assertEquals(true, checker.isValid("()"));
//        assertEquals(true, checker.isValid("(){}[]"));
//        assertEquals(true, checker.isValid("([{}])"));
        assertEquals(false, checker.isValid(")(}{]["));
        assertEquals(false, checker.isValid("())({}}{()][]["));
    }
//
//    @Test
//    public void testInvalid() {
//        assertEquals(false, checker.isValid("[(])"));
//        assertEquals(false, checker.isValid("(}"));
//        assertEquals(false, checker.isValid("[(])"));
//        assertEquals(false, checker.isValid("[({})](]"));
//    }
}