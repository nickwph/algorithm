package practice_basic.merge;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nickwph on 11/10/15.
 *
 * O(nlg n)
 * http://algs4.cs.princeton.edu/22mergesort/images/mergesortTD.png
 * http://algs4.cs.princeton.edu/22mergesort/images/mergesortBU.png
 */
public class TopDownMergeSort {

    static void sort(int[] array) {
        sort(array, 0, array.length, null);
    }

    static void sort(int[] array, int start, int end, int[] temp) {
        if (end - start < 2) return;
        if (temp == null) temp = new int[array.length];

        // recursively divide into 2
        // time: O(lg n)
        int middle = (end + start) / 2;
        sort(array, start, middle, temp);
        sort(array, middle, end, temp);

        // merge for each conquer
        // time: O(n)
        int a = start;
        int b = middle;
        for (int i = start; i < end; i++) {
            if (a < middle && (b >= end || array[a] <= array[b])) {
                // arr[A] < arr[B] or when B finished
                temp[i] = array[a];
                a++;
            } else {
                // arr[B] < arr[A] or when A finished
                temp[i] = array[b];
                b++;
            }
        }
        // copy back to array
        System.arraycopy(temp, start, array, start, end - start);
    }


    public static void main(String[] args) {

        // generate array with random values
        // Original Array: [5, 10, 19, 1, 9, 15, 12, 0, 18, 3, 11, 11, 11, 4, 12, 9, 1, 14, 4, 10]
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(array.length);
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(array));

        // sort array with heapsort
        // Sorted Array:   [0, 1, 1, 3, 4, 4, 5, 9, 9, 10, 10, 11, 11, 11, 12, 12, 14, 15, 18, 19]
        sort(array);
        System.out.print("Sorted Array:   ");
        System.out.println(Arrays.toString(array));
    }
}
