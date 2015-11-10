/**
 * Created by nickwph on 10/28/15.
 */
public class BalancePointPractice_Multiple {

    static int getBalancePointList(int[] array) {
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

    public static void main(String[] args) {
        int[] array = new int[]{-1, 2, 6, -5, 6};
        System.out.println(getBalancePointList(array));
    }
}
