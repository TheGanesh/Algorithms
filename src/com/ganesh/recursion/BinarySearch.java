package com.ganesh.recursion;

import java.util.Arrays;

public class BinarySearch {


    private int[] storageArray = new int[20];

    private void initialize() {
        for (int i = 0; i < 10; i++) {
            storageArray[i] = (i + 2);
        }
    }

    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();
        bs.initialize();
        System.out.println(Arrays.toString(bs.storageArray));
        System.out.println("Position is:" + bs.binarySearch(10, 0, bs.storageArray.length - 1));

    }

    private int binarySearch(int value, int low, int hi) {


        if (low <= hi) {
            int mid = (low + hi) / 2;
            if (value == storageArray[mid]) {
                return mid;
            } else if (value < storageArray[mid]) {
                return binarySearch(value, low, mid - 1);
            } else if (value > storageArray[mid]) {
                return binarySearch(value, mid + 1, hi);
            }
        }
        return -1;

    }
}



