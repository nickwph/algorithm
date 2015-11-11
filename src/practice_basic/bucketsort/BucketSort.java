package practice_basic.bucketsort;

import practice_basic.count.CountingSort;
import practice_basic.insertion.InsertionSort;

import java.util.List;

import static java.lang.System.arraycopy;
import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.format;

/**
 * Created by nickwph on 11/10/15.
 */
public class BucketSort {

    static void sort(int[] array) {
        sort(array, 10);
    }

    static void sort(int[] array, int bucketCount) {
        int[][] bucketArray = new int[bucketCount][0];

        for (int item : array) {
            int key = item / bucketCount;
            bucketArray[key] = addToArray(bucketArray[key], item);
        }

        // sort each bucket with insertion sort
        // time: O(n^2) depends on method
        for (int[] bucket : bucketArray) {
            // A common optimization is to put the unsorted elements of the
            // buckets back in the original array first, then run insertion
            // sort over the complete array; because insertion sort's runtime
            // is based on how far each element is from its final position, the
            // number of comparisons remains relatively small, and the memory
            // hierarchy is better exploited by storing the list contiguously in memory.
            InsertionSort.sort(bucket);
        }

        // copy back values
        // time: O(n)
        int count = 0;
        for (int[] bucket : bucketArray) {
            arraycopy(bucket, 0, array, count, bucket.length);
            count += bucket.length;
        }
    }

    static int[] addToArray(int[] array, int item) {
        int[] newArray = new int[array.length + 1];
        arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = item;
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(20);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
    }
}
