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
    public List<Integer> postorderTraversal(TreeNode root) {
        /*T(n) = O(n)
        S(n) = O(h) = O(logn) or O(n)*/
        List<Integer> res = new ArrayList<>();
        post(res, root);
        return res;
    }
    private void post(List<Integer> res, TreeNode node){
        if(node == null){
            return;
        }
        post(res,node.left);
        post(res,node.right);
        res.add(node.val);
    }
}