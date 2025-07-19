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
    Map<Integer, Integer> map = new HashMap<>();
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        idx = postorder.length - 1;
        return build(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int[] inorder, int s, int e) {
        if(s > e) return null;
        int curr = postorder[idx--];
        TreeNode root = new TreeNode(curr);
        int id = map.get(curr);
        root.right = build(postorder, inorder, id + 1, e);
        root.left = build(postorder, inorder, s, id - 1);
        return root;
    }
}