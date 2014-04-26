package com.ganesh.sorting;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class QuickSort {


    private void quickSort(int[] numbers, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSort(numbers, low, j);
        if (i < high)
            quickSort(numbers, i, high);
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void main(String args[]) throws Exception {


        QuickSort qs = new QuickSort();

        Random rn = new Random();
        int max = 40;
        int min = 0;

        int[] storageArray = new int[20];
        for (int i = 0; i < 20; i++) {
            storageArray[i] = rn.nextInt((max - min) + 1) + min;
        }

        qs.print(storageArray);
        qs.quickSort(storageArray, 0, storageArray.length - 1);
        qs.print(storageArray);
    }
}
