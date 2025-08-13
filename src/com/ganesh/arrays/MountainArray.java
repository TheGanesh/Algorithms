package com.ganesh.arrays;

public class MountainArray {

    // A mountain array is defined as an array that has the following properties:

    // 1. It has at least 3 elements.
    // 2. There exists some index i (0 < i < arr.length - 1) such that:
    //    - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    //    - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    // Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        // 1. Initial Check: Array must have at least 3 elements
        if (n < 3) {
            return false;
        }

        int i = 0;
        // 2. Find the increasing part: Traverse until the array stops strictly increasing
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // 3. Peak cannot be the first or last element:
        //    If 'i' is the first or last element, it's not a valid mountain
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 4. Find the decreasing part: Traverse from the peak until the array stops strictly decreasing
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // 5. Final Validation: If 'i' has reached the end of the array, it's a valid mountain array
        return i == n - 1;
    }

}
