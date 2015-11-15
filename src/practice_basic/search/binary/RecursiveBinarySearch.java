package practice_basic.search.binary;

import practice_basic.sort.quicksort.ThreeWayRadixQuickSort;
import utility.ArrayUtils;

import java.util.Random;

/**
 * Created by nickwph on 11/14/15.
 */
public class RecursiveBinarySearch {

    static int binarySearch(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    static int binarySearch(int[] arr, int key, int low, int hgh) {
        if (hgh < low) {

            // test if array is empty
            // set is empty, so return value showing not found
            throw new RuntimeException("Key not found");

        } else {

            // calculate midpoint to cut set in half
            int mid = (hgh + low) / 2;

            // three-way comparison
            if (arr[mid] > key) {
                // key is in lower subset
                return binarySearch(arr, key, low, mid - 1);
            } else if (arr[mid] < key) {
                // key is in upper subset
                return binarySearch(arr, key, mid + 1, hgh);
            } else {
                // key has been found
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.createRandomArray(100, 100000);
        ThreeWayRadixQuickSort.sort(arr);
        int key = new Random().nextInt(100);
        System.out.println("Key: " + key);
        int found = binarySearch(arr, arr[key]);
        System.out.println("Found: " + key);
        assert found == key;
    }
}
