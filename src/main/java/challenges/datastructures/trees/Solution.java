package challenges.datastructures.trees;

class Solution {
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge.
   Hint: you may want to write one or more helper functions.

    The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    static boolean checkBST(Node root) {
        if(root == null) {
            return true;
        } else {
            int value = root.data;
            if(root.left != null) {
                if(!checkBSTLeftBranch(root.left, value)) return false;
            }
            if(root.right != null) {
                if(!checkBSTRightBranch(root.right, value)) return false;
            }
        }
        return checkBST(root.left) && checkBST(root.right);
}

    private static boolean checkBSTLeftBranch(Node root, int value) {
        if(root == null) {
            return true;
        } else {
            if(root.data >= value) return false;
        }
        return checkBSTLeftBranch(root.left, value) && checkBSTLeftBranch(root.right, value);
    }

    private static boolean checkBSTRightBranch(Node root, int value) {
        if(root == null) {
            return true;
        } else {
            if(root.data <= value) return false;
        }
        return checkBSTRightBranch(root.left, value) && checkBSTRightBranch(root.right, value);
    }
}
