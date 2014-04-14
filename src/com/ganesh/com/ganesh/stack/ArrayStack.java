package com.ganesh.com.ganesh.stack;


import java.util.Arrays;

public class ArrayStack {


    private int[] stack = new int[20];

    private int index;

    private void initialize() {
        for (int i = 0; i < 5; i++) {
            stack[i] = (i + 1);
        }
        index = 4;
    }

    public ArrayStack(int[] stack) {
        this.stack = stack;
        index = stack.length - 1;
    }

    public void push(int i) {
        if (!isFull()) {
            index++;
            stack[index] = i;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            stack[index] = 0;
            index--;
        }
    }

    private boolean isEmpty() {
        return index == -1;
    }

    private boolean isFull() {
        return index == 19;
    }

    public int peek() {

        if (!isEmpty()) {
            return stack[index];
        }
        return -1;
    }

    public void print() {
        System.out.println("Index:" + index);
        System.out.println(Arrays.toString(stack));
    }

    public static void main(String[] args) {

        ArrayStack as = new ArrayStack(new int[20]);
        as.initialize();
        as.print();
        as.push(20);
        as.print();
        as.pop();
        as.print();
        System.out.println("peek:" + as.peek());

    }

}
