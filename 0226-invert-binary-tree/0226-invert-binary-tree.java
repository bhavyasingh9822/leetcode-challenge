class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null)) return root;
        TreeNode l=root.left;
        TreeNode r=root.right;
        root.left=r;
        root.right=l;
        
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
}