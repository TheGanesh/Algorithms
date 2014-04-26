package com.ganesh.arrays;


import java.util.Arrays;

public class MergeTwoSortedArrays {


    private void print(int[] a) {
        System.out.println(Arrays.toString(a));
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


    public static void main(String[] args) {

        int[] arrayA = new int[10];
        int[] arrayB = new int[10];

        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < 20; i++) {
            if ((i % 2) == 0) {
                arrayA[indexA] = i;
                indexA++;
            }
        }
        for (int i = 1; i < 20; i++) {
            if ((i % 2) != 0) {
                arrayB[indexB] = i;
                indexB++;
            }
        }

        MergeTwoSortedArrays ms = new MergeTwoSortedArrays();

        ms.print(arrayA);
        ms.print(arrayB);
        int sizeC = arrayA.length + arrayB.length;
        int[] arrayC = new int[sizeC];

        ms.merge(arrayA, arrayB, arrayC);

        ms.print(arrayC);
    }
}
