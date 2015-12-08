package practice_basic.search.binary;

import practice_basic.sort.quicksort.ThreeWayRadixQuickSort;
import utility.ArrayUtils;

import java.util.Random;

/**
 * Created by nickwph on 11/15/15.
 */
public class IterativeBinarySearch {

    static int binarySearch(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    static int binarySearch(int arr[], int key, int low, int hgh) {

        // continue searching while [imin,imax] is not empty
        while (low <= hgh) {

            // calculate the midpoint for roughly equal partition
            int mid = (hgh + low) / 2;

            // calculate midpoint to cut set in half
            if (arr[mid] == key) {
                // key found at index imid
                return mid;
                // determine which subarray to search
            } else if (arr[mid] < key) {
                // change min index to search upper subarray
                low = mid + 1;
            } else {
                // change max index to search lower subarray
                hgh = mid - 1;
            }
        }
        // key was not found
        throw new RuntimeException("Key not found");
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
