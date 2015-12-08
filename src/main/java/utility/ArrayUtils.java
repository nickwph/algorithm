package utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    public static String[] createRandomStringArray(int size) {
        String[] alphabets = {"adssdaf", "adsf", "eqwr", "adsf", "teqw", "sdfg", "rerew", "sgsdfg", "qewrsad", "sdgas"};
        List<String> list = Arrays.asList(alphabets);
        Collections.shuffle(list);
        return list.toArray(new String[list.size()]);
    }

    public static int[] createRandomArray(int size) {
        return createRandomArray(size, size);
    }

    public static int[] createRandomArray(int size, int range) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(range);
        return array;
    }

    public static int[] createReversedArray(int size) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = array.length - i - 1;
        return array;
    }

    public static int[] createArray(int size) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = i;
        return array;
    }

    public static String format(int[] array) {
        return Arrays.toString(array);
    }

    public static String format(int[] array, int lo, int hi) {
        int length = hi - lo;
        if (length > 0) {
            int[] newArray = new int[length];
            System.arraycopy(array, lo, newArray, 0, length);
            return Arrays.toString(newArray);
        }
        return "[]";
    }

    // find the max value in array
    // time: O(n)
    public static int findMax(int[] array) {
        int max = -1;
        for (int item : array) if (item > max) max = item;
        return max;
    }

    // is the array sorted
    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }

    // is the array sorted
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
