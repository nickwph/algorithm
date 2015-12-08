package practice_basic.sort.count;

import java.util.Arrays;

import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.findMax;
import static utility.ArrayUtils.format;

/**
 * Created by nickwph on 11/11/15.
 */
public class CountingSort {

    static void sort(int[] array) {

        // k is a number such that all keys are in the range 0..k-1
        // time: O(n)
        int k = findMax(array) + 1;

        // create counter array with all zero
        // time: O(n)
        int[] count = new int[k];
        Arrays.fill(count, 0);

        // calculate the histogram of key frequencies
        // time: O(n)
        for (int item : array) count[item]++;

        // calculate the starting index for each key
        // time: O(n)
        for (int i = 1; i < k; i++) count[i] += count[i - 1];

        // create a temporary output array
        // minus one to the counter
        // and get new position
        // time: O(n)
        int[] output = new int[array.length];
        for (int item : array) {
            count[item]--;
            output[count[item]] = item;
        }

        // copy back the result
        // time: O(n)
        System.arraycopy(output, 0, array, 0, output.length);
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(20);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
    }
}
