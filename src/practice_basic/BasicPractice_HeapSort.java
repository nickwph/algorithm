import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nickwph on 10/18/15.
 */
public class BasicPractice_HeapSort {

    static class Node {
        int value;
        Node left, right;
        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static boolean visit(Node node) {
        return node.value == 1;
    }

    static boolean breatheFirstIterativeTraversal(Node root) {
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.poll();
            if (node == null) continue;
            if (!visit(node)) return false;
            stack.add(node.left);
            stack.add(node.right);
        }
        return true;
    }

    static void verifyGoodTree() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(1, null, null);
        Node node4 = new Node(1, node2, node3);
        Node node5 = new Node(1, node4, node1);
        Node node6 = new Node(1, null, null);
        Node node7 = new Node(1, null, null);
        Node node8 = new Node(1, node7, node6);
        Node node9 = new Node(1, node8, node5);
        System.out.println("Should be true: " + breatheFirstIterativeTraversal(node9));
    }

    static void verifyBadTree() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(1, null, null);
        Node node4 = new Node(1, node2, node3);
        Node node5 = new Node(1, node4, node1);
        Node node6 = new Node(1, null, null);
        Node node7 = new Node(2, null, null);
        Node node8 = new Node(1, node7, node6);
        Node node9 = new Node(1, node8, node5);
        System.out.println("Should be false: " + breatheFirstIterativeTraversal(node9));
    }

    public static void main(String[] args) {
        verifyGoodTree();
        verifyBadTree();
    }
}
