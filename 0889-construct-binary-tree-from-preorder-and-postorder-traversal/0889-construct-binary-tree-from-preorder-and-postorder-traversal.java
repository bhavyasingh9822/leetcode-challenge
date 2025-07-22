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
    int preind = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // \U0001f5fa️ Build a map from postorder values to their indices
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return help(preorder, map, 0, postorder.length - 1);
    }

    private TreeNode help(int[] preorder, Map<Integer, Integer> map, int s, int e) {
        if (preind >= preorder.length || s > e) return null;

        int rootVal = preorder[preind++];
        TreeNode root = new TreeNode(rootVal);

        // \U0001f331 Base case: only one node in this subtree
        if (s == e) return root;

        // \U0001f9ed Get index of left child from postorder using preorder[preind]
        int postind = map.get(preorder[preind]);

        // \U0001f528 Recursively construct left and right subtrees
        root.left = help(preorder, map, s, postind);
        root.right = help(preorder, map, postind + 1, e - 1); // exclude root

        return root;
    }
}