import java.util.Stack;

/**
 * Created by nickwph on 10/18/15.
 */
public class InterviewPractice21 {

    private static Stack<Integer> snapsack = new Stack<>();

    private static void found(int n) {
        for (int item : snapsack) System.out.printf("%d + ", item);
        System.out.printf("%d\n", n);
    }

    private static void find_combination(int target, int n) {
        if (target <= 0 || n <= 0) return;
        if (n == target) found(n);
        snapsack.push(n);
        find_combination(target - n, n - 1);
        snapsack.pop();
        find_combination(target, n - 1);
    }

    public static void main(String[] args) {
        find_combination(25, 20);
    }
}