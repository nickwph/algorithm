package utility;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nickwph on 11/10/15.
 */
public class ArrayUtils {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] createRandomArray(int size) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(array.length);
        return array;
    }

    public static int[] createReversedArray(int size) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = array.length - i - 1;
        return array;
    }

    public static String format(int[] array) {
        return Arrays.toString(array);
    }
}
