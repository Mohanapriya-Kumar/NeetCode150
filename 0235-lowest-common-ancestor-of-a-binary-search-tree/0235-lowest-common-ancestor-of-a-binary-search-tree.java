/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*Find in which subtree the nodes are present
        T(n) = O(h) 
        S(n) = O(h) h = logn or n (balanced/skewed)*/
        if(root == null || p == null || q == null) return null;
        if(p.val < root.val && q.val < root.val){//both nodes are in left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){//both nodes are in right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
    }
}