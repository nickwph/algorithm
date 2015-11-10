import java.util.Arrays;

/**
 * Created by nickwph on 10/28/15.
 */
public class BalancePointPractice {

    static int findSingleBalancePoint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int totalFromLeft = 0;
            int totalFromRight = 0;
            for (int j = 0; j < i; j++) {
                totalFromLeft += array[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                totalFromRight += array[j];
            }
            if (totalFromLeft == totalFromRight) {
                return i;
            }
        }
        return -1;
    }

    static int[] findBalancePointList(int[] array, int size) {
        for (int i = 0; i < array.length - size; i++) {
            int totalFromLeft = 0;
            int totalFromRight = 0;
            for (int j = 0; j < i; j++) {
                totalFromLeft += array[j];
            }
            for (int j = i + size; j < array.length; j++) {
                totalFromRight += array[j];
            }
            if (totalFromLeft == totalFromRight) {
                return Arrays.copyOfRange(array, i, i + size);
            }
        }
        return null;
    }

    static int[] findBalancePointList(int[] array) {
        for (int size = 1; size <= array.length; size++) {
            int[] result = findBalancePointList(array, size);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{-1, 2, 6, -5, 6};
        System.out.println(findSingleBalancePoint(array1));
        System.out.println(Arrays.toString(findBalancePointList(array1)));

        int[] array2 = new int[]{-1, 2, 6, 3, -5, 6};
        System.out.println(findSingleBalancePoint(array2));
        System.out.println(Arrays.toString(findBalancePointList(array2)));

        int[] array3 = new int[]{-1, 2, 6, 3, -5, 6, 0};
        System.out.println(findSingleBalancePoint(array3));
        System.out.println(Arrays.toString(findBalancePointList(array3)));
    }
}
