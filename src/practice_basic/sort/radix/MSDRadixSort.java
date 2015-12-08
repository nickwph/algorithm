package practice_basic.sort.radix;

import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;
import static utility.ArrayUtils.findMax;
import static utility.MathUtils.getNumberOfDigits;

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
        int exp = getNumberOfDigits(max);

        System.out.println("Max:      " + max);
        System.out.println("Exponent: " + exp);

        // sort recursively by each digit
        // from left to right
        // O(kn)
        sort(array, 0, array.length, exp);
    }

    private static void sort(int[] array, int lo, int hi, int exp) {
        if (hi <= lo + 1 || exp < 1) return;

        // run counting sort at exponent in range lo and hi
        // counter return indicts the range for each buckets
        int[] counter = countingSortAtExpInRange(array, lo, hi, exp);

        // recursively run sort in each bucket
        for (int i = 0; i < counter.length - 1; i++) {
            sort(array, counter[i], counter[i + 1], exp / 10);
        }
    }

    // look at counting sort for more idea
    // run counting sort at exp in range lo and hi
    // time: O(kn)
    private static int[] countingSortAtExpInRange(int[] array, int lo, int hi, int exp) {

        // time: O(n)
        int k = 10;
        int[] counter = new int[k];
        fill(counter, 0);

        // time: O(n)
        for (int i = lo; i < hi; i++) {
            int key = (array[i] / exp) % 10;
            counter[key]++;
        }

        // time: O(n)
        for (int i = 1; i < k; i++) counter[i] += counter[i - 1];

        // time: O(n)
        int[] output = new int[array.length];
        for (int i = lo; i < hi; i++) {
            int key = (array[i] / exp) % 10;
            counter[key]--;
            output[counter[key] + lo] = array[i];
        }

        // time: O(n)
        arraycopy(output, lo, array, lo, hi - lo);
        return counter;
    }
}
