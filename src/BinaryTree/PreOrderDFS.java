package BinaryTree;


import java.util.ArrayList;
import java.util.List;
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
public class PreOrderDFS {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode current = s.pop();
            traversal.add(current.val);
            if(current.right != null) {
                s.push(current.right);
            }
            if(current.left != null) {
                s.push(current.left);
            }
        }
        return traversal;
    }
}
