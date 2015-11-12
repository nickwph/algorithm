package practice_basic.quicksort;

import java.util.Arrays;

import static utility.ArrayUtils.*;
import static utility.MathUtils.getDigitAtPlace;
import static utility.MathUtils.getNumberOfDigits;

/**
 * Created by nickwph on 11/11/15.
 */
public class ThreeWayRadixQuickSort {

    public static void sort(int[] a) {
        int max = findMax(a);
        int exp = getNumberOfDigits(max);
//        System.out.println(max + "->" + exp);
        sort(a, 0, a.length - 1, exp);
    }

    // 3-way string quicksort a[lo..hi] starting at dth character
    private static void sort(int[] a, int lo, int hi, int d) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo || d < 0) {
            return;
        }

        int lt = lo, gt = hi;
        int v = getDigitAtPlace(a[lo], d);

        int i = lo + 1;
        while (i <= gt) {
            int t = getDigitAtPlace(a[i], d);
            if (t < v) swap(a, lt++, i++);
            else if (t > v) swap(a, i, gt--);
            else i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d - 1);
        sort(a, gt + 1, hi, d);
    }

    /**
     * Reads in a sequence of fixed-length strings from standard input;
     * 3-way radix quicksorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] array = createRandomArray(10, 1000);
            System.out.println("Original: " + format(array));
            sort(array);
            System.out.println("Sorted:   " + format(array));
            System.out.println("IsSorted: " + isSorted(array));
            System.out.println();
        }
    }
}
