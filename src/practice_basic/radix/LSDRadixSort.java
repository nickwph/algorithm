package practice_basic.radix;

import java.util.Arrays;

import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;
import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.findMax;
import static utility.ArrayUtils.format;

/**
 * Created by nickwph on 11/10/15.
 * <p/>
 * Time: O(kn)
 */
public class LSDRadixSort {

    public static void sort(int[] array) {
        // counting sort for each digit bucket
        // from right to left
        // time: O(kn)
        int max = findMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortAtExp(array, exp);
        }
    }

    // look at counting sort for more idea
    // time: O(kn)
    static void countingSortAtExp(int[] array, int exp) {
        // time: O(n)
        int k = 10;
        int[] counter = new int[k];
        fill(counter, 0);

        // time: O(n)
        for (int item : array) {
            int key = (item / exp) % 10;
            counter[key]++;
        }

        // time: O(n)
        for (int i = 1; i < k; i++) counter[i] += counter[i - 1];

        // time: O(n)
        int[] output = new int[array.length];
        for (int item : array) {
            int key = (item / exp) % 10;
            counter[key]--;
            output[counter[key]] = item;
        }

        // time: O(n)
        arraycopy(output, 0, array, 0, output.length);
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(20, 10000);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
    }
}
