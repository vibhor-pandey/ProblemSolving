package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class BinaryTreeInorderDFS {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> inorder = new ArrayList<>();
        TreeNode current = root;
        while(current != null || !s.isEmpty()) {
            while(current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            inorder.add(current.val);
            current = current.right;
        }
        return inorder;
    }
}
