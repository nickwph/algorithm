package practice_basic;

import java.util.Arrays;
import java.util.Random;

public class BasicPractice_Heap {

    public static void main(String[] args) {

        // generate array with random values
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(array.length);
        System.out.print("Original Array:  ");
        System.out.println(Arrays.toString(array));

        // create heap from the array
        Heap heap = new Heap(array);
        System.out.print("Heapified Array: ");
        System.out.println(Arrays.toString(heap.getHeapArray()));

        // sort array with heapsort
        int[] sorted = heap.getSortedArray();
        System.out.print("Sorted Array:    ");
        System.out.println(Arrays.toString(sorted));
    }

    public static class Heap {

        private int[] storage;

        public Heap(int[] array) {
            storage = new int[array.length];
            System.arraycopy(array, 0, storage, 0, array.length);
            int total = storage.length - 1;
            for (int i = total / 2; i >= 0; i--) {
                heapify(storage, i, total);
            }
        }

        private void heapify(int[] array, int parentNode, int total) {
            int leftChildNode = parentNode * 2;
            int rightChildNode = leftChildNode + 1;
            int greater = parentNode;
            if (leftChildNode <= total && array[leftChildNode] > array[greater]) greater = leftChildNode;
            if (rightChildNode <= total && array[rightChildNode] > array[greater]) greater = rightChildNode;
            if (greater != parentNode) {
                swap(array, parentNode, greater);
                heapify(array, greater, total);
            }
        }

        private void swap(int[] arr, int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        public int[] getHeapArray() {
            return storage;
        }

        public int[] getSortedArray() {
            int[] arr = new int[storage.length];
            System.arraycopy(storage, 0, arr, 0, storage.length);
            int total = arr.length - 1;
            for (int i = total; i > 0; i--) {
                swap(arr, 0, i);        // put the largest to the end
                total--;                // adjust sorting range
                heapify(arr, 0, total); // heapify elements in the range
            }
            return arr;
        }
    }
}