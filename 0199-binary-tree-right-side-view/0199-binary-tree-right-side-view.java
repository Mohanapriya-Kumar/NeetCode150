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
    public List<Integer> rightSideView(TreeNode root) {
        /*Use BFS: keep updating right while traversing the breadth
        T(n) = O(n)
        S(n) = O(n)*/
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int bsize = q.size();
            TreeNode r = null;
            for (int i = 0; i < bsize; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    r = node;
                    if (node.left != null)
                        q.offer(node.left);
                    if (node.right != null)
                        q.offer(node.right);
                }
            }
            if (r != null)
                res.add(r.val);
        }
        return res;
    }
}