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
    public boolean isValidBST(TreeNode root) {
        /*Use min and max val > min && val < max note: use long
        T(n) = O(n)
        S(n) = O(h) = O(logn) or O(n)*/
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return validate(root,min,max);
    }
    private boolean validate(TreeNode node, long min, long max){
        if(node == null) return true;
        if(!(node.val > min && node.val < max)) return false;
        return validate(node.left, min, node.val)//dn left: curr node is the max
        && validate(node.right, node.val, max);//dn right: curr node is the min
    }
}