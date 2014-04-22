package com.ganesh.sorting;


import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

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

    private void insertionSort() {

        int lastIndex = storageArray.length - 1;

        for (int outer = 1; outer <= lastIndex; outer++) {

            int outerValue = storageArray[outer];
            int insertionPoint = -1;

            for (int i = 0; i <= outer - 1; i++) {
                if (outerValue < storageArray[i]) {
                    insertionPoint = i;
                    break;
                }
            }

            if (insertionPoint != -1) {
                System.arraycopy(storageArray, insertionPoint, storageArray, insertionPoint + 1, (outer - insertionPoint));
                storageArray[insertionPoint] = outerValue;
            }

        }
    }


    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        is.initialize();
        is.print();
        is.insertionSort();
        is.print();

    }
}
