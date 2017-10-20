package challenges.datastructures.linkedlists;

public class Solution {

    static boolean hasCycle(Node head) {
        Node current = head;
        Node previous;
        if(current != null) {
            while (current.getNext() != null) {
                current = current.getNext();
                previous = head;
                while (previous != current) {
                    if (current.getNext() == previous) return true;
                    previous = previous.getNext();
                }
            }
        }
        return false;
    }
}
