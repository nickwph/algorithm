import java.util.*;

/**
 * Created by nickwph on 10/18/15.
 */
public class BasicPractice_Snapsack {

    private static Stack<Integer> mSnapsack = new Stack<>();

    private static void printSnapsack() {
        int total = 0;
        for (int i = 0; i < mSnapsack.size(); i++) {
            total += mSnapsack.get(i);
            System.out.printf(String.valueOf(mSnapsack.get(i)));
            System.out.printf((i < mSnapsack.size() - 1) ? " + " : " = " + total + "\n");
        }
    }

    private static void findCombinations(List<Integer> list, int target, int position) {
        if (target <= 0 || position < 0 || position >= list.size() || list.get(position) <= 0) {
            // invalid target or position
            return;
        }
        int value = list.get(position);
        if (target == value) {
            // solution found, print snapsack
            mSnapsack.push(value);
            printSnapsack();
            mSnapsack.pop();
            return;
        }
        // push the current value and found combination recursively
        mSnapsack.push(value);
        findCombinations(list, target - value, position - 1);
        mSnapsack.pop();
        // finished matching current value, move to the next one
        findCombinations(list, target, position - 1);
    }

    private static void findCombinations(List<Integer> list, int target) {
        // values must be small to large
        Collections.sort(list);
        findCombinations(list, target, list.size() - 1);
    }

    public static void main(String[] args) {
        findCombinations(Arrays.asList(1, 5, 2, 2, 3, 7, 6, 4, 10), 27);
        // 10 + 7 + 6 + 4 = 27
        // 10 + 7 + 5 + 4 + 1 = 27
        // 10 + 7 + 5 + 3 + 2 = 27
        // 10 + 7 + 5 + 2 + 2 + 1 = 27
        // 10 + 7 + 4 + 3 + 2 + 1 = 27
        // 10 + 7 + 4 + 3 + 2 + 1 = 27
        // 10 + 6 + 5 + 4 + 2 = 27
        // 10 + 6 + 5 + 3 + 2 + 1 = 27
        // 10 + 6 + 5 + 3 + 2 + 1 = 27
        // 10 + 6 + 4 + 3 + 2 + 2 = 27
        // 10 + 5 + 4 + 3 + 2 + 2 + 1 = 27
        // 7 + 6 + 5 + 4 + 3 + 2 = 27
        // 7 + 6 + 5 + 4 + 2 + 2 + 1 = 27
    }
}