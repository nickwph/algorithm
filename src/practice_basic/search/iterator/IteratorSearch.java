package practice_basic.search.iterator;

import practice_basic.sort.quicksort.ThreeWayRadixQuickSort;
import utility.ArrayUtils;

import java.util.*;

/**
 * Created by nickwph on 11/16/15.
 */
public class IteratorSearch {

    static boolean search(int[] array, int key) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) list.add(i);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println("Checking: " + value);
            if (value == key) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.createRandomArray(100, 100000);
        ThreeWayRadixQuickSort.sort(arr);
        int key = new Random().nextInt(100);
        System.out.println("Key: " + key + "->" + arr[key]);

        boolean found = search(arr, arr[key]);
        System.out.println("Found: " + found);
        assert found;
    }
}
