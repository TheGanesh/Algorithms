package com.ganesh.sorting;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MergeSort {

    public int[] mergeSort(int[] list) {

        if (list.length <= 1) {
            return list;
        }

        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // Sort each half
        first = mergeSort(first);
        second = mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }

    private void merge(int[] first, int[] second, int[] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

    private void print(int[] storageArray) {
        System.out.println(Arrays.toString(storageArray));
    }

    public static void main(String args[]) throws Exception {


        MergeSort ms = new MergeSort();

        Random rn = new Random();
        int max = 40;
        int min = 0;

        int[] storageArray = new int[20];
        for (int i = 0; i < 20; i++) {
            storageArray[i] = rn.nextInt((max - min) + 1) + min;
        }

        ms.print(storageArray);
        storageArray = ms.mergeSort(storageArray);
        ms.print(storageArray);
    }
}
