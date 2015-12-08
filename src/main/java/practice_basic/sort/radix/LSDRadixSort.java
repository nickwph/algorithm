package practice_basic.sort.radix;

import utility.MathUtils;

import static utility.ArrayUtils.findMax;

/**
 * Created by nickwph on 11/10/15.
 * <p/>
 * Time: O(kn)
 */
public class LSDRadixSort {


    // Sort the numbers beginning with least-significant digit
    public static void sort(int[] input) {
        int max = findMax(input);
        int count = MathUtils.getExponent(max);
        // Largest place for a 32-bit int is the 1 billion's place
        for (int place = 1; place <= count; place *= 10) {
            // Use counting sort at each digit's place
            countingSort(input, place);
        }
    }

    private static void countingSort(int[] input, int place) {
        int[] out = new int[input.length];
        int[] count = new int[10];

        for (int i = 0; i < input.length; i++) {
            int digit = getDigit(input[i], place);
            count[digit]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = input.length - 1; i >= 0; i--) {
            int digit = getDigit(input[i], place);
            out[--count[digit]] = input[i];
        }
        System.arraycopy(out, 0, input, 0, out.length);

    }

    private static int getDigit(int value, int digitPlace) {
        return ((value / digitPlace) % 10);
    }
}
