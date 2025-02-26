package org.example;
import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        // checks if given empty string as input
        if (s.isEmpty()) return false;

        // creates stack to track valid parentheses in input string
        Stack<Character> stack = new Stack<>();

        // traverses string to check for valid parentheses
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')'); // tracks beginning of ()
            else if (c == '{') stack.push('}'); // tracks beginning of {}
            else if (c == '[') stack.push(']'); // tracks beginning of []
            // returns false if stack is empty but there are still chars in string
            // or if char on top of stack is not valid parenthesis for current pair being tracked
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty(); // stack will be empty if all parentheses are valid
    }
}
