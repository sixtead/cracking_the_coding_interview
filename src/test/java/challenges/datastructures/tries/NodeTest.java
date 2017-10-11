package challenges.datastructures.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeTest {
    @Test
    void constructor() {
        Node trie = new Node();
        assertTrue(trie.children.isEmpty());
        assertFalse(trie.wordEnd);
    }

    @Test
    void addChar() {
        Node trie = new Node();
//  add character and check size and value presence
        trie.addChar('a', false);
        assertTrue(trie.children.size() == 1);
        assertTrue(trie.children.containsKey('a'));
//  add same character and check that size is the same
        trie.addChar('a', false);
        assertTrue(trie.children.size() == 1);
//  add new character and check size increased and value is present
        trie.addChar('b', false);
        assertTrue(trie.children.size() == 2);
        assertTrue(trie.children.containsKey('a'));
        assertTrue(trie.children.containsKey('b'));
    }

    @Test
    void addWord() {
        Node trie = new Node();
        trie.addWord("hack");
        trie.addWord("hackerrank");
        assertTrue(trie.children.size() == 1);
        assertTrue(trie.children.containsKey('h'));
        Node h = trie.children.get('h');
        assertTrue(h.children.size() == 1);
        assertTrue(h.children.containsKey('a'));
        Node a = h.children.get('a');
        assertTrue(a.children.size() == 1);
        assertTrue(a.children.containsKey('c'));
        assertFalse(a.children.containsKey('k'));
        Node c = a.children.get('c');
        assertFalse(c.wordEnd);
        assertTrue(c.children.size() == 1);
        assertTrue(c.children.containsKey('k'));
        Node k = c.children.get('k');
        assertTrue(k.wordEnd);
        assertTrue(k.children.size() == 1);
        assertTrue(k.children.containsKey('e'));
    }

    @Test
    void countWords() {
        Node trie = new Node();
        trie.addWord("hack");
        trie.addWord("hackerrank");
        assertEquals(0, trie.countWords("hak"));
        assertEquals(2, trie.countWords("hac"));
    }

}