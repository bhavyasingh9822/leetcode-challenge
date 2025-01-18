 class Solution {
    static int sum=0;
    public void helper(TreeNode root,int[] sum){
        if(root==null) return;
        helper(root.right,sum);
        root.val=root.val+sum[0];
        sum[0]=root.val;
        helper(root.left,sum);
    }
    public TreeNode convertBST(TreeNode root) {
        int[] sum=new int[1];
        sum[0]=0;
        helper(root,sum);
        return root;
    }
}