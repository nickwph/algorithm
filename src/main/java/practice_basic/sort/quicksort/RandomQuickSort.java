package practice_basic.sort.quicksort;

import java.util.Random;

import static utility.ArrayUtils.*;

/**
 * Created by nickwph on 11/11/15.
 */
public class RandomQuickSort {

    static void sort(int[] arr) {
        // generate a random index
        int randomIndex = new Random().nextInt(arr.length);

        // this quick sort uses last index as pivot
        // swap it with the random index
        // so the random index will be used as pivot
        swap(arr, arr.length - 1, randomIndex);
        HoarePartitionQuickSort.sort(arr);
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        int[] arr = createRandomArray(10, 1000);
        System.out.println("Original: " + format(arr));
        sort(arr);
        System.out.println("Sorted:   " + format(arr));
        System.out.println("IsSorted: " + isSorted(arr));
    }
}
