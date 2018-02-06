package challenges.algorithms.dfs;

import java.util.HashMap;

public class Node {
    int id;
    private int data;
    private HashMap<Integer, Node> adjacent;

    Node(int id, int data) {
        this.id = id;
        this.data = data;
        this.adjacent = new HashMap<>();
    }

    int getId() {
        return id;
    }

    int getData() {
        return data;
    }

    HashMap getAdjacent() {
        return adjacent;
    }

    void connect(Node node) {
        adjacent.put(node.getId(), node);
    }
}
