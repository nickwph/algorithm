package practice_basic.sort.merge;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.min;
import static java.lang.System.arraycopy;

/**
 * Created by nickwph on 11/10/15.
 *
 * O(nlg n)
 * http://algs4.cs.princeton.edu/22mergesort/images/mergesortBU.png
 */
public class BottomUpMergeSort {

    static void sort(int[] array) {
        int size = array.length;
        int[] temp = new int[size];

        // for half-width is 1, 2, 4, 8, 16, ....
        // -> [1,2], [3,4], [5,6], [7,8]
        // -> [1,2,3,4], [5,6,7,8]
        // -> [1,2,3,4,5,6,7,8]
        // O(lg n)
        for (int halfWidth = 1; halfWidth < size; halfWidth *= 2) {

            // for each part with width
            // O(1) <- just going to each part
            for (int start = 0; start < size; start += 2 * halfWidth) {
                int middle = min(start + halfWidth, size);  // [1]
                int end = min(start + 2 * halfWidth, size); // [2]

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
            }
            // copy back all sorted parts
            arraycopy(temp, 0, array, 0, size);
        }
    }

    public static void main(String[] args) {

        // generate array with random values
        // Original Array: [5, 10, 19, 1, 9, 15, 12, 0, 18, 3, 11, 11, 11, 4, 12, 9, 1, 14, 4, 10]
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)  array[i] = new Random().nextInt(array.length);
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(array));

        // sort array with heapsort
        // Sorted Array:   [0, 1, 1, 3, 4, 4, 5, 9, 9, 10, 10, 11, 11, 11, 12, 12, 14, 15, 18, 19]
        sort(array);
        System.out.print("Sorted Array:   ");
        System.out.println(Arrays.toString(array));
    }
}
