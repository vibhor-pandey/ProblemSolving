package BinaryTree;


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
public class MaximumDepth {
    int ans = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        depth(root, 0);
        return ans + 1;
    }

    private void depth(TreeNode node, int depth) {
        if (node == null) return;
        if(node.left == null && node.right == null) {
            ans = Math.max(ans, depth);
        }
        depth(node.left, depth + 1);
        depth(node.right, depth + 1);
    }
}
