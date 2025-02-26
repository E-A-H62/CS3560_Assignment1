package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    // creates instance of class to call valid parentheses method
    private ValidParentheses parentheses;

    @BeforeEach // defines instance of class
    public void setUp() {parentheses = new ValidParentheses();}

    @Test // tests valid parentheses method for with provided test cases
    public void testsIsValid() {
        assertTrue(parentheses.isValid("()"), "The string '()' should be valid");
        assertTrue(parentheses.isValid("()[]{}"), "The string '()[]{}' should be valid");
        assertFalse(parentheses.isValid("(]"), "The string '(]' should be invalid");
        assertFalse(parentheses.isValid("([)]"), "The string '([)]' should be invalid");
    }

    @Test // test case checking empty string
    void testEmptyString() {
        assertFalse(parentheses.isValid(""), "An empty string should be invalid");
    }

    @Test // test case checking long input string
    void testLongString() {
        String s = "()[][]([{{[()]}}]){}([])";
        assertTrue(parentheses.isValid(s), "The string '()[][]([{{[()]}}]){}([])' should be valid");
    }
}
