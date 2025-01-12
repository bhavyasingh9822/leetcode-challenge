class Solution {
    public TreeNode helper(int[] preorder,int prelow,int prehigh, int[] inorder, int inlow,int inhigh){
        if(prelow>prehigh) return null;
        TreeNode root=new TreeNode(preorder[prelow]);
        int i=inlow;
        while(inorder[i]!=preorder[prelow]) i++;
        int leftSize=i-inlow;
        root.left=helper(preorder, prelow+1, prelow+leftSize, inorder, inlow, i-1);
        root.right=helper(preorder, prelow+leftSize+1, prehigh, inorder, i+1, inhigh);
       return root; 
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        //int m=inorder.lenght;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}