package practice_basic.data.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickwph on 11/17/15.
 */
public class Trie {

    private Node root = new Node();

    public void insert(String word) {
        HashMap<Character, Node> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            Node node;
            char character = word.charAt(i);
            if (children.containsKey(character)) {
                node = children.get(character);
            } else {
                node = new Node();
                node.character = character;
                children.put(character, node);
            }
            children = node.children;
            if (i == word.length() - 1) node.isLeaf = true;
        }
    }

    public boolean contains(String word) {
        Node node = get(word);
        return node != null && node.isLeaf;
    }

    private static class Node {
        char character;
        boolean isLeaf;
        HashMap<Character, Node> children = new HashMap<>();
    }

    private Node get(String word) {
        Map<Character, Node> children = root.children;
        Node node = null;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (children.containsKey(character)) {
                node = children.get(character);
                children = node.children;
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("adgasd");
        trie.insert("dassag");
        System.out.println("abcd:     " + trie.contains("abcd"));
        System.out.println("adgasd:   " + trie.contains("adgasd"));
        System.out.println("new_word: " + trie.contains("new_word"));
        trie.insert("new_word");
        System.out.println("new_word: " + trie.contains("new_word"));
    }
}
