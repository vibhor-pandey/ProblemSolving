package BinarySearchTree;

import java.util.Stack;

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
public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while(!s.isEmpty()) {
            TreeNode curr = s.pop();
            if(curr.val == val) return curr;
            else if(curr.val < val && curr.right != null) {
                s.push(curr.right);
            } else if (curr.val > val && curr.left != null) {
                s.push(curr.left);
            }
        }
        return null;
    }
}
