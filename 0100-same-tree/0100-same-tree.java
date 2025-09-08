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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*Check if both/anyone null, check val!=, recursive call for left && right
        T(n) = O(n)
        S(n) = O(h) = O(n) worst case*/
        if(p == null && q == null) return true; //two checks for null
        if(p == null || q == null) return false;
        if(p.val != q.val) return false; //val doesn't match actual code
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}