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
    public int goodNodes(TreeNode root) {
        /*Use DFS to compute maxSoFar
        T(n) = O(n)
        S(n) = O(h) = O(logn) or O(n)*/
        return dfs(root,root.val);
    }
    private int dfs(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        int count = 0;
        if(node.val >= maxSoFar){
            count = 1;//Local for recursive call
            maxSoFar = node.val;
        }
        count += dfs(node.left,maxSoFar); //recursion
        count += dfs(node.right,maxSoFar);
        return count;
    }
}