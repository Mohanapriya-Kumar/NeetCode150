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
    private int inidx = 0, preidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);   
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int lim){
        if(preidx >= preorder.length){
            return null; // used all nodes
        }
        if(inorder[inidx] == lim){ //lim for left is root.val, right max
            inidx++; // reached the end of a subtree
            return null;
        }
        TreeNode node = new TreeNode(preorder[preidx++]);//postincrement for next root
        node.left = dfs(preorder, inorder, node.val); //go dwon complete building left
        node.right = dfs(preorder, inorder,lim);//then build right => ///dfs
        return node;
    }
}