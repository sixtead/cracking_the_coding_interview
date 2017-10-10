package challenges.datastructures.triescontacts;

import java.util.HashMap;

class Node {
    HashMap<Character, Node> children;
    boolean wordEnd = false;

    Node() {
        this.children = new HashMap<>();
    }

    private Node(boolean wordEnd) {
        this.children = new HashMap<>();
        this.wordEnd = wordEnd;
    }

    void addChar(char c, boolean wordEnd) {
        if(!children.containsKey(c)) {
            children.put(c, new Node(wordEnd));
        }
    }

    void addWord(String w) {
        Node curr = this;

        for(int i = 0; i < w.length() - 1; i++) {
            curr.addChar(w.charAt(i), false);
            curr = curr.children.get(w.charAt(i));
        }
        curr.addChar(w.charAt(w.length() - 1), true);
    }

    int countWords(String s) {
        Node curr = this;

        for(char c: s.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return 0;
            } else {
                curr = curr.children.get(c);
            }
        }
        return curr.countWords();
    }

    private int countWords() {
        int count = 0;
        if(wordEnd) count++;
        if(children.isEmpty()) {
            return count;
        }
        return count + children.values().stream().mapToInt(Node::countWords).sum();
    }
}
