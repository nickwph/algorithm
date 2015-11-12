package practice_basic.quicksort;

import java.util.Arrays;

import static utility.ArrayUtils.createRandomStringArray;
import static utility.ArrayUtils.isSorted;

/**
 * Created by nickwph on 11/11/15.
 */
public class StringThreeWayRadixQuickSort {

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    // return the dth character of s, -1 if d = length of s
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    // 3-way string quicksort a[lo..hi] starting at dth character
    private static void sort(String[] a, int lo, int hi, int d) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo) {
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Reads in a sequence of fixed-length strings from standard input;
     * 3-way radix quicksorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        String[] array = createRandomStringArray(20);
        System.out.println("Original: " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted:   " + Arrays.toString(array));
        System.out.println("IsSorted: " + isSorted(array));
    }
}
