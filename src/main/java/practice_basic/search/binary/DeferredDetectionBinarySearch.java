package practice_basic.search.binary;

import practice_basic.sort.quicksort.ThreeWayRadixQuickSort;
import utility.ArrayUtils;

import java.util.Random;

/**
 * Created by nickwph on 11/15/15.
 * <p/>
 * The above iterative and recursive versions take
 * three paths based on the key comparison: one path
 * for less than, one path for greater than, and one
 * path for equality. (There are two conditional branches.)
 * The path for equality is taken only when the record
 * is finally matched, so it is rarely taken. That
 * branch path can be moved outside the search loop
 * in the deferred test for equality version of the
 * algorithm. The following algorithm uses only one
 * conditional branch per iteration.[4]
 */
public class DeferredDetectionBinarySearch {


    static int binarySearch(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    // inclusive indices
    //   0 <= imin when using truncate toward zero divide
    //     imid = (imin+imax)/2;
    //   imin unrestricted when using truncate toward minus infinity divide
    //     imid = (imin+imax)>>1; or
    //     imid = (int)floor((imin+imax)/2.0);
    static int binarySearch(int[] arr, int key, int low, int hgh) {
        // continually narrow search until just one element remains
        while (low < hgh) {
            int imid = (low + hgh) / 2;

            // code must guarantee the interval is reduced at each iteration
            assert (imid < hgh);
            // note: 0 <= imin < imax implies imid will always be less than imax

            // reduce the search
            if (arr[imid] < key) low = imid + 1;
            else hgh = imid;
        }
        // At exit of while:
        //   if A[] is empty, then imax < imin
        //   otherwise imax == imin

        // deferred test for equality
        if ((hgh == low) && (arr[low] == key)) {
            return low;
        }
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
