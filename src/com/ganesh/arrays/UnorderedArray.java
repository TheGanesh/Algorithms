package com.ganesh.arrays;


import java.util.Arrays;
import java.util.Random;

public class UnorderedArray {

    private int[] storageArray = new int[20];
    private int index;

    private void initialize() {

        Random rn = new Random();
        int max = 40;
        int min = 0;

        for (int i = 0; i < 10; i++) {
            storageArray[i] = rn.nextInt((max - min) + 1) + min;
        }
        index = 9;
    }

    private void insert(int i) {
        System.out.println("inserting:" + i);
        ++index;
        storageArray[index] = i;
    }

    private void delete(int i) {
        int di = find(i);

        if (di != -1) {
            System.arraycopy(storageArray, di + 1, storageArray, di, index - di);
            storageArray[index] = 0;
            index--;
        }
    }

    private int find(int j) {

        for (int i = 0; i <= index; i++) {
            if (j == storageArray[i]) {
                System.out.println("Index of " + j + " is:" + i);
                return i;
            }
        }
        return -1;
    }

    private void print() {
        System.out.println(Arrays.toString(storageArray));
        System.out.println("index:" + index);

    }

    public static void main(String[] args) {

        UnorderedArray unorderedArray = new UnorderedArray();
        unorderedArray.initialize();
        unorderedArray.print();
        unorderedArray.insert(8);
        unorderedArray.print();
        unorderedArray.insert(21);
        unorderedArray.insert(30);
        unorderedArray.print();

        unorderedArray.delete(8);
        unorderedArray.print();

        unorderedArray.find(21);


    }

}
