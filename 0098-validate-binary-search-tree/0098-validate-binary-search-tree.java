class Solution {
    static boolean flag=true;
    static TreeNode  prev=null;
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(prev==null) prev=root;
        else if(root.val<=prev.val){
            flag=false;
        }
        else prev =root;
        inOrder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        flag=true;
        prev=null;
        inOrder(root);
      return flag;
    }
}