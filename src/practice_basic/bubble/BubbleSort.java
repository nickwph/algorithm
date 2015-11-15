package practice_basic.bubble;

import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.format;
import static utility.ArrayUtils.swap;

/**
 * Created by nickwph on 11/10/15.
 *
 * Time: O(n^2)
 */
public class BubbleSort {

    public static void sort(int[] array) {
        // for each element
        // time: O(n)
        for (int i = 0; i < array.length - 1; i++) {
            // for each value except the last one in this loop
            // time: O(n)
            for (int j = 0; j < array.length - i - 1; j++) {
                // pull larger value to the right
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(20);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
    }
}
