package practice_basic.sort.quicksort;

import static utility.ArrayUtils.*;

/**
 * Created by nickwph on 11/10/15.
 * <p/>
 * Hoare partition scheme
 * Time: O(nlg n)
 * <p/>
 * The original partition scheme described by C.A.R. Hoare uses two indices that
 * start at the ends of the array being partitioned, then move toward each other,
 * until they detect an inversion: a pair of elements, one greater than the pivot,
 * one smaller, that are in the wrong order relative to each other. The inverted
 * elements are then swapped. When the indices meet, the algorithm stops and
 * returns the final index.
 * <p/>
 * There are many variants of this algorithm, for example, selecting pivot from
 * A[hi] instead of A[lo]. Hoare's scheme is more efficient than Lomuto's partition
 * scheme because it does three times fewer swaps on average, and it creates
 * efficient partitions even when all values are equal.
 * <p/>
 * Like Lomuto's partition scheme, Hoare partitioning also causes Quicksort to
 * degrade to O(n2) when the input array is already sorted; it also doesn't produce
 * a stable sort. Note that in this scheme, the pivot's final location is not
 * necessarily at the index that was returned, and the next two segments that the
 * main algorithm recurs on are [lo..p] and (p..hi] as opposed to [lo..p) and (p..hi]
 * as in Lomuto's scheme.
 */
public class HoarePartitionQuickSort {

    static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    static void sort(int[] array, int lo, int hi) {
        if (lo < hi) {
            // find pivot, divide and sort recursively
            // time: O(lg n) or worst O(n)
            int p = hoarePartition(array, lo, hi);
            sort(array, lo, p);
            sort(array, p + 1, hi);
        }
    }

    static int hoarePartition(int[] array, int lo, int hi) {
        // get the value to compare with
        int pivot = array[hi - 1];
        int lft = lo - 1;
        int rgt = hi + 1;
        while (true) {
            // find index from left with larger value
            // find index from right with smaller value
            // time: O(n)
            while (array[++lft] < pivot) ;
            while (array[--rgt] > pivot) ;
            // swap them if index is not inverted
            // otherwise pivot is found
            if (lft < rgt) swap(array, lft, rgt);
            else return rgt;
        }
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(20);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
    }
}
