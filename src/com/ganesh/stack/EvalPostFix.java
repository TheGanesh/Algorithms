package com.ganesh.stack;


import java.util.Stack;

public class EvalPostFix {

    public static void main(String[] args) {

        String postfix = "123431+/-*+";

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < postfix.length(); i++) {

            char c = postfix.charAt(i);
            String value = "" + c;
            Integer one = null;
            Integer two = null;
            switch (c) {
                case '+':
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two + one);
                    break;
                case '-':
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two - one);
                    break;
                case '*':
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two * one);
                    break;
                case '/':
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two / one);
                    break;

                default:
                    stack.push(Integer.valueOf(value));

            }

            System.out.println(stack);
        }
    }
}
