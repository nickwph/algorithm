package practice_basic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* Class HeapSort */
public class BasicPractice_HeapSort {


    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void heapify(int[] arr, int i, int total) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && arr[lft] > arr[grt]) grt = lft;
        if (rgt <= total && arr[rgt] > arr[grt]) grt = rgt;
        if (grt != i) {
            swap(arr, i, grt);
            heapify(arr, grt, total);
        }
    }

    public static void sort(int[] arr) {
        int total = arr.length - 1;
        for (int i = total / 2; i >= 0; i--) {
            heapify(arr, i, total);
        }
        for (int i = total; i > 0; i--) {
            swap(arr, 0, i);
            total--;
            heapify(arr, 0, total);
        }
    }

    public static void main(String[] args) {
        // generate array with random values
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(array.length);
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(array));
        // sort array with heapsort
        sort(array);
        System.out.print("Sorted Array:   ");
        System.out.println(Arrays.toString(array));
    }
}