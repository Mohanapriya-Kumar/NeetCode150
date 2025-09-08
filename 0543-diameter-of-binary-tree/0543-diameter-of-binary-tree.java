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
    private int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return d;
    }
    private int depth(TreeNode node){
        /*Using helper fn depth that uses recursion
        T(n) = O(n)
        S(n) = O(h) = O(n) worst case*/
        if(node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        d = Math.max(d,leftDepth + rightDepth); 
        //d = len of the longest path between any two nodes in the tree
        return Math.max(leftDepth, rightDepth) + 1;
    }
}