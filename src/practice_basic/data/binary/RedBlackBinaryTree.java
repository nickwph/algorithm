package practice_basic.data.binary;

/**
 * Created by nickwph on 11/18/15.
 */
public class RedBlackBinaryTree {

    private static final int COLOR_RED = 0;
    private static final int COLOR_BLACK = 1;

    private static class Node {
        int value;
        int color;
        Node left;
        Node right;
    }

    private Node root;

    public boolean contains(int value) {
        return contains(root, value);
    }

    public boolean contains(Node node, int value) {
        // totally same as binary tree
        if (node == null) return false;
        if (node.value == value) return true;
        if (value < node.value) return contains(node.left, value);
        if (value > node.value) return contains(node.right, value);
        return false;
    }

    public void insert(int value) {
        root = insert(root, value);
        root.color = COLOR_BLACK;
    }

    private Node insert(Node parent, int value) {
        // terminating condition
        // create a tree if it has no parent
        // new node has to be red
        if (parent == null) {
            Node node = new Node();
            node.value = value;
            node.color = COLOR_RED;
            return node;
        }

        // basic binary insert
        if (value < parent.value) {
            parent.left = insert(parent.left, value);
        } else if (value > parent.value) {
            parent.right = insert(parent.right, value);
        }

        // validate and update tree
        if (parent.right != null && parent.right.color == COLOR_RED &&
                parent.left != null && parent.left.color == COLOR_BLACK) {
            parent = rotateLeft(parent);
        }
        if (parent.left != null && parent.left.color == COLOR_RED &&
                parent.left.left != null && parent.left.left.color == COLOR_RED) {
            parent = rotateRight(parent);
        }
        if (parent.left != null && parent.left.color == COLOR_RED &&
                parent.right != null && parent.right.color == COLOR_RED) {
            flipColors(parent);
        }

        // return a validated node
        return parent;
    }

    public void delete(int value) {
//        if (!contains(key)) {
//            System.err.println("symbol table does not contains " + key);
//            return;
//        }

//        // if both children of root are black, set root to red
//        if (!isRed(root.left) && !isRed(root.right))
//            root.color = RED;
//
//        root = delete(root, key);
//        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

//    // delete the key-value pair with the given key rooted at h
//    private Node delete(Node h, Key key) {
//        // assert get(h, key) != null;
//
//        if (key.compareTo(h.key) < 0)  {
//            if (!isRed(h.left) && !isRed(h.left.left))
//                h = moveRedLeft(h);
//            h.left = delete(h.left, key);
//        }
//        else {
//            if (isRed(h.left))
//                h = rotateRight(h);
//            if (key.compareTo(h.key) == 0 && (h.right == null))
//                return null;
//            if (!isRed(h.right) && !isRed(h.right.left))
//                h = moveRedRight(h);
//            if (key.compareTo(h.key) == 0) {
//                Node x = min(h.right);
//                h.key = x.key;
//                h.val = x.val;
//                // h.val = get(h.right, min(h.right).key);
//                // h.key = min(h.right).key;
//                h.right = deleteMin(h.right);
//            }
//            else h.right = delete(h.right, key);
//        }
//        return balance(h);
//    }

    private Node rotateLeft(Node parent) {
        // right node will be the new parent
        Node node = parent.right;
        // old parent's left will be old right's left
        parent.right = node.left;
        // old parent will be new parent's left
        node.left = parent;
        node.left.color = COLOR_RED;
        node.color = node.left.color;
        return node;
    }

    private Node rotateRight(Node parent) {
        Node node = parent.left;
        parent.left = node.right;
        node.right = parent;
        node.right.color = COLOR_RED;
        node.color = node.right.color;
        return node;
    }

    private void flipColors(Node parent) {
        parent.color = (parent.color + 1) % 2;
        parent.left.color = (parent.left.color + 1) % 2;
        parent.right.color = (parent.right.color + 1) % 2;
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
        System.out.print(prefix);
        System.out.print(isTail ? "└── " : "├── ");
        System.out.print(node != null ? node.value : "null");
        System.out.println(node != null ? node.color == COLOR_RED?"(RED)":"(BLACK)" : "");
        if (node != null) {
            print(node.right, prefix + (isTail ? "    " : "│   "), false);
            print(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        RedBlackBinaryTree tree = new RedBlackBinaryTree();
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
