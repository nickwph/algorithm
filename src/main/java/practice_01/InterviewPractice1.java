public class InterviewPractice1 {
    // global
    static Node node_root = null;
    static Node node_temp = null;

    // node structure
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // visit
    private static void visit(Node node) {
        if (node_temp == null) node_root = node; // set head
        else node_temp.right = node; // make right of temp to this node
        node.left = node_temp; // make temp to the left of this node
        node_temp = node; // next node

    }

    // depth first, recursive
    private static void depth_first_recursive_traversal_in_order(Node node) {
        if (node == null) return;
        depth_first_recursive_traversal_in_order(node.left);
        visit(node);
        depth_first_recursive_traversal_in_order(node.right);
    }

    // main
    public static void main(String[] args) {
        // tree
        Node node_5 = new Node(5, null, null);
        Node node_7 = new Node(7, null, null);
        Node node_9 = new Node(9, null, null);
        Node node_1 = new Node(1, null, null);
        Node node_6 = new Node(6, node_5, node_7);
        Node node_0 = new Node(0, node_9, node_1);
        Node node_8 = new Node(8, node_6, node_0);

        // run
        node_root = node_8;
        depth_first_recursive_traversal_in_order(node_root);

        // the result should be 5 6 7 8 9 0 1
        node_temp = node_root;
        while (node_temp != null) {
            System.out.print(node_temp.value + " ");
            node_temp = node_temp.right;
        }
    }
}
