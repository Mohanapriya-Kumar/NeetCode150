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
    /*Max(no(left),no(right)+1) Recursive Approach
    T(n) = O(n)
    S(n) = O(h) = O(n) at worst case*/
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftNodes = maxDepth(root.left);
        int rightNodes = maxDepth(root.right);
        return Math.max(leftNodes, rightNodes) + 1;
    }
}