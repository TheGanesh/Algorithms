package com.ganesh.sorting;


import java.util.Arrays;
import java.util.Random;

public class BubbleSort {


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

    public void bubbleSort() {
        int lastIndex = storageArray.length - 1;

        for (int j = lastIndex; j >= 0; j--) {
            for (int i = 0; i <= j && (i + 1) <= lastIndex; i++) {
                if (storageArray[i] > storageArray[i + 1]) {
                    int temp = storageArray[i];
                    storageArray[i] = storageArray[i + 1];
                    storageArray[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        bs.initialize();
        bs.print();
        bs.bubbleSort();
        bs.print();

    }


}
