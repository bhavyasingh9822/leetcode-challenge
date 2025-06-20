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
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res; 
    }
     static void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postOrder(node.left, res);// Left subtree
        postOrder(node.right, res);     // Right subtree
        res.add(node.val);             // Visit root
    }
}