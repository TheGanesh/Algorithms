package com.ganesh.recursion;


public class TrianglerNumbers {


    public static void main(String[] args) {
        System.out.println(triangularNumbers(6));

    }

    public static int triangularNumbers(int i) {

        if (i == 1)
            return 1;
        else
            return i + triangularNumbers(i - 1);

    }
}
