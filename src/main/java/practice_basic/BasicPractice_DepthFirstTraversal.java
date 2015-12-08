import java.util.Stack;

/**
 * Created by nickwph on 10/18/15.
 */
public class BasicPractice_DepthFirstTraversal {

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

    static boolean depthFirstTraversal_preOrder(Node node) {
        if (node == null) return true;
        if (!visit(node)) return false;
        if (!depthFirstTraversal_preOrder(node.left)) return false;
        if (!depthFirstTraversal_preOrder(node.right)) return false;
        return true;
    }

    static boolean depthFirstTraversal_inOrder(Node node) {
        if (node == null) return true;
        if (!depthFirstTraversal_inOrder(node.left)) return false;
        if (!visit(node)) return false;
        if (!depthFirstTraversal_inOrder(node.right)) return false;
        return true;
    }

    static boolean depthFirstTraversal_postOrder(Node node) {
        if (node == null) return true;
        if (!depthFirstTraversal_postOrder(node.left)) return false;
        if (!depthFirstTraversal_postOrder(node.right)) return false;
        if (!visit(node)) return false;
        return true;
    }

    static boolean depthFirstIterativeTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node == null) continue;
            if (!visit(node)) return false;
            stack.push(node.right);
            stack.push(node.left);
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
        System.out.println("Should be true: " + depthFirstTraversal_preOrder(node9));
        System.out.println("Should be true: " + depthFirstTraversal_inOrder(node9));
        System.out.println("Should be true: " + depthFirstTraversal_postOrder(node9));
        System.out.println("Should be true: " + depthFirstIterativeTraversal(node9));
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
        System.out.println("Should be false: " + depthFirstTraversal_preOrder(node9));
        System.out.println("Should be false: " + depthFirstTraversal_inOrder(node9));
        System.out.println("Should be false: " + depthFirstTraversal_postOrder(node9));
        System.out.println("Should be false: " + depthFirstIterativeTraversal(node9));
    }

    public static void main(String[] args) {
        verifyGoodTree();
        verifyBadTree();
    }
}
