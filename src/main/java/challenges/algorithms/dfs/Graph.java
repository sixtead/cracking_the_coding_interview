package challenges.algorithms.dfs;

import java.util.HashMap;

public class Graph {
    private HashMap<Integer, Node> nodes = new HashMap<>();

    void add(int id, int data) {
        nodes.put(id, new Node(id, data));
    }

    void connect(int firstId, int secondId) {
        Node firstNode = nodes.get(firstId);
        Node secondNode = nodes.get(secondId);
        firstNode.connect(secondNode);
        secondNode.connect(firstNode);
    }
}
