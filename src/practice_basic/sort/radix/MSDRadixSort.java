package practice_basic.sort.radix;

import static java.lang.System.arraycopy;
import static utility.ArrayUtils.findMax;
import static utility.MathUtils.getExponent;

/**
 * Created by nickwph on 11/10/15.
 * <p/>
 * Time: O(kn)
 */
public class MSDRadixSort {

    public static void sort(int[] array) {

        // find the most significant digit
        // [432521] -> exp=100000
        int max = findMax(array);
        int exp = getExponent(max);

        System.out.println("Max:      " + max);
        System.out.println("Exponent: " + exp);

        // sort recursively by each digit
        // from left to right
        // O(kn)
        sort(array, 0, array.length, exp);
    }

    private static void sort(int[] array, int lo, int hi, int exp) {
        if (hi <= lo || hi - lo == 1 || exp < 1) return;

        // run counting sort at exponent in range lo and hi
        // counter return indicts the range for each buckets
        int[] count = countingSort(array, lo, hi, exp);

        // recursively run sort in each bucket
        for (int i = 0; i < count.length - 1; i++) {
            sort(array, count[i] + lo, count[i + 1] + lo, exp / 10);
        }
        sort(array, count[count.length - 1] + lo, hi, exp / 10);
    }

    // look at counting sort for more idea
    // run counting sort at exp in range lo and hi
    // time: O(kn)
    private static int[] countingSort(int[] input, int lo, int hi, int place) {
        int[] counter = new int[10];

        // time: O(n)
        for (int i = lo; i < hi; i++) {
            int key = getDigit(input[i], place);
            counter[key]++;
        }

        // time: O(n)
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        // time: O(n)
        int[] output = new int[input.length];
        for (int i = lo; i < hi; i++) {
            int digit = getDigit(input[i], place);
            output[--counter[digit] + lo] = input[i]; // add base
        }

        // time: O(n)
        arraycopy(output, lo, input, lo, hi - lo);
        return counter;
    }

    private static int getDigit(int value, int digitPlace) {
        return ((value / digitPlace) % 10);
    }
}
