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
class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: compute total sum of tree
        totalSum = getTotalSum(root);

        // Step 2: compute max product by trying all subtree splits
        computeSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = computeSubtreeSum(node.left);
        long right = computeSubtreeSum(node.right);

        long subTreeSum = node.val + left + right;

        // product if we cut above this subtree
        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
