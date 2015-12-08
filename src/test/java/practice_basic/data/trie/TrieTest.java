package practice_basic.data.trie;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nickwph on 12/6/15.
 */
public class TrieTest {

    @Test
    public void test() throws Exception {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("adgasd");
        trie.insert("dassag");
        assertTrue(trie.contains("abcd"));
        assertTrue(trie.contains("abcd"));
        assertTrue(trie.contains("adgasd"));
        assertFalse(trie.contains("new_word"));
        trie.insert("new_word");
        assertTrue(trie.contains("new_word"));
    }
}