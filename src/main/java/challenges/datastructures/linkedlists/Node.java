package challenges.datastructures.linkedlists;

class Node {
    private int data;
    private Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

}
