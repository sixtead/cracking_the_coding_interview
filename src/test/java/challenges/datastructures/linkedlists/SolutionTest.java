package challenges.datastructures.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void hasCycle() {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);
        node3.setNext(node2);
        assertTrue(Solution.hasCycle(head));
    }

    @Test
    void hasNoCycle() {
        Node head = new Node(1, null);
        assertFalse(Solution.hasCycle(head));
    }

}