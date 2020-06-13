package com.ganesh.divideAndConquer;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++) {
            intArray[i] = (i + 2);
        }

        System.out.println(Arrays.toString(intArray));
        int valueToSearch = 12;
        System.out.println("Index of value " + valueToSearch + " is " + binarySearch(intArray, 0, intArray.length - 1, valueToSearch));
    }

    /**
     * T(n) = T(n/2) + 1
     * T(n) = [T(n/4) + 1] + 1
     * T(n) = T(n/4) + 1 + 1
     * T(n) = [T(n/8)+1] + 1 + 1 = = T(n/2^k) + k
     * n/2^k = 1 => k = log(n);
     * T(n) = 1 + log(n) = O(logN)
     */
    private static int binarySearch(int[] storedArray, int low, int high, int valueToSearch) {

        if (low > high) {
            System.out.println("low " + low + " high " + high);
            return -1;//not found
        }
        int midIndex = (low + high) / 2;
        int midValue = storedArray[midIndex];
        if (valueToSearch == midValue) {
            return midIndex;
        } else if (valueToSearch < midValue) {
            return binarySearch(storedArray, low, midIndex - 1, valueToSearch);
        } else {
            return binarySearch(storedArray, midIndex + 1, high, valueToSearch);
        }
    }
}
