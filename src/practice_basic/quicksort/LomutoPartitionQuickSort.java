package practice_basic.quicksort;

import static java.lang.System.out;
import static utility.ArrayUtils.*;

/**
 * Created by nickwph on 11/10/15.
 * <p/>
 * Lomuto partition scheme
 * Time: O(nlg n)
 * <p/>
 * This scheme is attributed to Nico Lomuto and popularized by Bentley in his book
 * Programming Pearls and Cormen et al. in their book Introduction to Algorithms.
 * <p/>
 * This scheme chooses a pivot which is typically the last element in the array.
 * The algorithm maintains the index to put the pivot in variable i and each time
 * when it finds an element less than or equal to pivot, this index is incremented
 * and that element would be placed before the pivot.
 * <p/>
 * As this scheme is more compact and easy to understand, it is frequently used in
 * introductory material, although it is less efficient than Hoare's original
 * scheme. This scheme degrades to O(n^2) when the array is already sorted as well
 * as when the array has all equal elements.
 * <p/>
 * There have been various variants proposed to boost performance including various
 * ways to select pivot, deal with equal elements, use other sorting algorithms such
 * as Insertion sort for small arrays and so on.
 */
public class LomutoPartitionQuickSort {

    static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    static void sort(int[] array, int lo, int hi) {
        if (lo < hi) {
            // find pivot
            int p = lomutoPartition(array, lo, hi);
            // divide and sort recursively, excluding pivot point
            // time: O(lg n) or worst O(n)
            sort(array, lo, p - 1);
            sort(array, p + 1, hi);
        }
    }

    static int lomutoPartition(int[] arr, int low, int hgh) {

        // group smaller values together
        // and group larger values together
        // [2, 1, 3], [6, 5, 7], [p=4]
        // time: O(n)
        int i = low;
        int pivot = arr[hgh];
        for (int j = low; j < hgh; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        // place pivot after smaller values
        // and before larger values
        // [2, 1, 3], [p=4], [6, 5, 7]
        swap(arr, i, hgh);
        return i;
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(10, 1000);
        out.println("Original: " + format(array));
        sort(array);
        out.println("Sorted:   " + format(array));
        out.println("IsSorted: " + isSorted(array));
    }
}
