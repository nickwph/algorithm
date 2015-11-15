package practice_basic.sort.insertion;

import static utility.ArrayUtils.createRandomArray;
import static utility.ArrayUtils.format;

/**
 * Created by nickwph on 11/11/15.
 */
public class InsertionSort {

    public static void sort(int[] array) {
        int j;
        int temp;
        // for each values in the array
        // time: O(n)
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            // shift values until a smaller value is found
            // time: O(n)
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(20);
        System.out.println("Original: " + format(array));
        sort(array);
        System.out.println("Sorted:   " + format(array));
    }
}
