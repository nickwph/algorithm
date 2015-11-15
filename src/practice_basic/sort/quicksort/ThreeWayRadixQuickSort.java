package practice_basic.sort.quicksort;

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
        sort(a, 0, a.length - 1, exp - 1);
    }

    private static void sort(int[] arr, int low, int hgh, int dgt) {
        if (hgh <= low || dgt < 0) return;

        // pivot as arr[0]
        // two pointers from left and right
        int lft = low;
        int rgt = hgh;
        int pvt = getDigitAtPlace(arr[low], dgt);

        // compare from i=1..n
        // if item is smaller, swap it with left pointer
        // else if item is larger, swap it with right pointer
        // else increase i
        // -> [22,11,41],[35,33,36],[55,86,57]
        int i = low + 1;
        while (i <= rgt) {
            int t = getDigitAtPlace(arr[i], dgt);
            if (t < pvt) swap(arr, lft++, i++);
            else if (t > pvt) swap(arr, i, rgt--);
            else i++;
        }

        // recursively sort in three ways
        // [22,11,41] -> run with the same method
        // [35,33,36] -> sort the next digit
        // [55,86,57] -> run with the same method
        sort(arr, low, lft - 1, dgt);
        if (pvt >= 0) sort(arr, lft, rgt, dgt - 1);
        sort(arr, rgt + 1, hgh, dgt);
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(10, 1000);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
        System.out.println("IsSorted: " + isSorted(array));
    }
}
