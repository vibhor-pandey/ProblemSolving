package BinarySearchTree;


import java.util.Stack;

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Integer prev = null;
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            prev = s.pop().val;
            curr = s.pop();
            if(prev != null && curr.val <= prev) {
                return false;
            }
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }
}
