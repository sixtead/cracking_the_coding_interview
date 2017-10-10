package challenges.datastructures.triescontacts;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    void addChar(Character c, boolean wordEnd) {
        if(!children.containsKey(c)) {
            children.put(c, new Node(wordEnd));
        }
    }

    void addWord(String w) {
        Queue<Character> q = new LinkedList<>();
        for(Character c: w.toCharArray()) q.add(c);
        addWord(q);
    }

    private void addWord(Queue<Character> w) {
        if(w.size() > 1) {
            Character c = w.poll();
            addChar(c, false);
            children.get(c).addWord(w);
        } else {
            addChar(w.poll(), true);
        }
    }

    int countWords(String s) {
        Queue<Character> q = new LinkedList<>();
        for(Character c: s.toCharArray()) q.add(c);

        return countWords(q);
    }

    private int countWords(Queue<Character> s) {
        if(s.size() > 0) {
            Character c = s.poll();
            if(!children.containsKey(c)) {
                return 0;
            } else {
                return children.get(c).countWords(s);
            }
        }
        return countWords();
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
