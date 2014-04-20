package com.ganesh.arrays;


import java.util.Arrays;

public class OrderedArray {

    private int[] storageArray = new int[20];

    private void initialize() {
        for (int i = 0; i < 10; i++) {
            storageArray[i] = (i + 1);
        }
    }

    private void insert(int key) {
        System.out.println("Inserting :" + key);
        int insertionPoint = -1;
        int lastIndex = storageArray.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            if (key < storageArray[i]) {
                insertionPoint = i;
                break;
            }
        }

        if (insertionPoint != -1) {
            System.arraycopy(storageArray, insertionPoint, storageArray, insertionPoint + 1, (lastIndex - insertionPoint));
            storageArray[insertionPoint] = key;
        }

    }

    private void delete(int i) {
        System.out.println("Deleting :" + i);

        int index = find(i);
        int lastIndex = storageArray.length - 1;
        if (index != -1) {
            System.arraycopy(storageArray, index + 1, storageArray, index, (lastIndex - index));
            storageArray[lastIndex] = 0;
        }

    }

    private int find(int key) {
        int lo = 0;
        int hi = storageArray.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (key == storageArray[mid]) {
                return mid;
            } else if (key < storageArray[mid]) {
                hi = mid - 1;
            } else if (key > storageArray[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private void print() {
        System.out.println(Arrays.toString(storageArray));
    }

    public static void main(String[] args) {
        OrderedArray orderedArray = new OrderedArray();
        orderedArray.initialize();
        orderedArray.print();
        orderedArray.insert(6);
        orderedArray.print();

        orderedArray.delete(9);
        orderedArray.print();
        System.out.println("index of 7 is:" + orderedArray.find(200));

    }
}
