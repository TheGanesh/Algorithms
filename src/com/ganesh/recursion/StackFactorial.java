package com.ganesh.recursion;


import java.util.Stack;

public class StackFactorial {

    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        System.out.println(factorial(3));

    }

    public static int factorial(int i) {

        for (int j = i; j >= 1; j--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                stack.push(stack.pop() * j);
            }
        }

        return stack.pop();
    }
}
