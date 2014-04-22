package com.ganesh.sorting;


import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    private int[] storageArray = new int[20];

    private void initialize() {

        Random rn = new Random();
        int max = 40;
        int min = 0;

        for (int i = 0; i < 20; i++) {
            storageArray[i] = rn.nextInt((max - min) + 1) + min;
        }
    }

    private void print() {
        System.out.println(Arrays.toString(storageArray));

    }

    private void selectionSort() {

        int lastIndex = storageArray.length - 1;

        for (int i = 0; i <= lastIndex; i++) {
            int smallestIndex = i;

            for (int j = i; j <= lastIndex; j++) {
                if (storageArray[j] < storageArray[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            int temp = storageArray[i];
            storageArray[i] = storageArray[smallestIndex];
            storageArray[smallestIndex] = temp;

        }

    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        ss.initialize();
        ss.print();
        ss.selectionSort();
        ss.print();

    }
}
