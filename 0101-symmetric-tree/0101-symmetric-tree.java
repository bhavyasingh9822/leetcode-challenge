class Solution {
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
       if(p.val!=q.val) return false;
       return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
    }
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        root.left=invertTree(root.left);
        return isSameTree(root.left,root.right);
    }
}