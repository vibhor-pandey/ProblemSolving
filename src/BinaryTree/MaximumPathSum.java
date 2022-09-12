package BinaryTree;
/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 */



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

/**
 * 1) Recursive solution
 * 2) Check Max_Gain for each node
 * 3) Each node's max gain will determine max gain of parent node
 *
 * (MAX_GAIN(Parent) = node.val + MAX(MAX_GAIN(left), MAX_GAIN(right)))
 * 4) Node == null return 0
 * 5) Check left_gain & right_gain
 * 6) Calculate path_sum = (left_gain + right_gain + node.val)
 * 7) Check Max of path_sum & max_sum
 * 8) return max_gain (node.val + max(left, right))
 */
public class MaximumPathSum {

    public int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        maxGain(root);
        return max_sum;
    }

    private int maxGain(TreeNode node) {
        if(node == null) return 0;

        int left_gain = Math.max(0, maxGain(node.left));
        int right_gain = Math.max(0, maxGain(node.right));

        int path_sum = node.val + left_gain + right_gain;

        max_sum = Math.max(path_sum, max_sum);

        return node.val + Math.max(left_gain, right_gain);
    }
}
