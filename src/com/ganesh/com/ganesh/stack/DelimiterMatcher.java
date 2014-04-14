package com.ganesh.com.ganesh.stack;

import java.util.Stack;

public class DelimiterMatcher {

    public static void main(String[] args) {

        String input = "a{b(c[d]e)f}(";

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' && '{' != stack.pop()) {
                System.out.println("Invalid expression..{");
            } else if (c == ')' && '(' != stack.pop()) {
                System.out.println("Invalid expression..(");
            } else if (c == ']' && '[' != stack.pop()) {
                System.out.println("Invalid expression..[");
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Invalid expression...stack not empty");
        }
    }
}
