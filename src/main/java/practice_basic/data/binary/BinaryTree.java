package practice_basic.data.binary;

/**
 * Created by nickwph on 11/18/15.
 */
public class BinaryTree {

    private Node root;

    private static class Node {
        Node left;
        Node right;
        int value;
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.value) {
            return true;
        } else if (data < node.value) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int value) {
        // terminating condition
        if (node == null) {
            node = new Node();
            node.value = value;
            return node;
        }
        // compare the node's value
        if (value < node.value) {
            // insert to the left node
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            // insert to the right node
            node.right = insert(node.right, value);
        } else {
            // value exists already
            System.out.println(value + " exists already");
        }
        return node;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            // cannot find node to delete
            return null;
        }
        if (value < node.value) {
            // recursively go to left
            // and assign left to the new left
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            // recursively go to right
            // and assign right to the new right
            node.right = delete(node.right, value);
        } else {
            // found node to delete
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)  {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            return node;
        }
    }

    void dump() {
        dump(root);
        System.out.println();
    }

    private void dump(Node node) {
        if (node == null) return;
        dump(node.left);
        System.out.print(node.value + " ");
        dump(node.right);
    }

    void print() {
        print(root, "", true);
    }

    private void print(Node node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + (node != null ? node.value : "null"));
        if (node != null) {
            print(node.right, prefix + (isTail ? "    " : "│   "), false);
            print(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(135);
        tree.insert(12);
        tree.insert(112);
        tree.insert(1123);
        tree.insert(42);
        tree.insert(462);
        tree.insert(125);
        tree.insert(46332);
        tree.insert(12);
        tree.insert(1235);
        tree.insert(312);
        tree.print();
        tree.dump();
        System.out.println("contain 112? " + tree.contains(112));
        tree.delete(112);
        tree.dump();
        System.out.println("contain 112? " + tree.contains(112));
        tree.dump();
        System.out.println("contain 46332? " + tree.contains(46332));
        tree.delete(46332);
        tree.dump();
        System.out.println("contain 46332? " + tree.contains(46332));
    }
}