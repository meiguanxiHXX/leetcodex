package leetcode20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidateBrackets {

    private static final List<Character> rightBrackets = new ArrayList<>(Arrays.asList(')', '}', ']'));

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (rightBrackets.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (!matchBrackets(stack.pop(), c)) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean matchBrackets(Character left, Character right) {
        if (left == '{') {
            return right == '}';
        } else if (left == '(') {
            return right == ')';
        } else {
            return right == ']';
        }
    }

    public static void main(String[] args) {
        ValidateBrackets validateBrackets = new ValidateBrackets();
        System.out.println(validateBrackets.isValid("(){}"));
    }
}
