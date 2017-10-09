package challenges.datastructures.treesisthisabinarysearchtree;

class Node {
    int data;
    Node left, right;

    private Node(int data) {
        this.data = data;
    }

    private Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    static Node createBinaryTree(int rootLeftLeftData, int rootLeftData, int rootLeftRightData,
                                 int rootData, int rootRightLeftData, int rootRightData,
                                 int rootRightRightData) {
//        [1, 2, 3, 4, 5, 6, 7]
//                  4
//                /   \
//               2     6
//              / \   / \
//             1   3 5   7
        Node rootLeftLeft = new Node(rootLeftLeftData);
        Node rootLeftRight = new Node(rootLeftRightData);
        Node rootRightLeft = new Node(rootRightLeftData);
        Node rootRightRight = new Node(rootRightRightData);
        Node rootLeft = new Node(rootLeftData, rootLeftLeft, rootLeftRight);
        Node rootRight = new Node(rootRightData, rootRightLeft, rootRightRight);
        return new Node(rootData, rootLeft, rootRight); //root
    }
}
