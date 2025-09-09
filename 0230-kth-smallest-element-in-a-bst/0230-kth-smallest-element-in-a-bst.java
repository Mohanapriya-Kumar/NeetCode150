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
    private int result = -1;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        /*Traverse left, c++ at node, if count == k return value, else traverse right
        T(n) = O(h+k) traversing full down and then k up => worst case: O(n)
        S(n) = O(h) = O(n) at worst case*/
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode node, int k){
        if(node == null) return;
        inorder(node.left, k);//it keeps moving to the leftmost element (1st smlst)
        count++;
        if(count == k){//check if count reached k
            result = node.val;
            return;
        }
        inorder(node.right, k);//c != k on left now right(of left subtree so is min)
    }
}