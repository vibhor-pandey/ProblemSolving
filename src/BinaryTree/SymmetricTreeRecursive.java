package BinaryTree;

import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SymmetricTreeRecursive {

    private boolean isMirror(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);

    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public void printQ(Queue<Integer> q) {
        for(int rc : q) {
            System.out.print(rc + ", ");
        }
        System.out.println();
    }
}
