class Solution {
    public void merge(List<Integer> a, List<Integer> b,List<Integer> ans){
     int i=0,j=0;
     while(i<a.size() && j<b.size()){
        if(a.get(i)<=b.get(j)){
            ans.add(a.get(i));
            i++;
        }
        else{
            ans.add(b.get(j));
            j++;
        }
     }
     if(i==a.size()){
        while(j<b.size()){
            ans.add(b.get(j));
            j++;
        }
     }
      if(j==b.size()){
        while(i<a.size()){
            ans.add(a.get(i));
            i++;
        }
     }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a=new ArrayList<>(); //root1 ke sare eelment sort krdo morris
        TreeNode curr=root1;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr) pred=pred.right;
                if(pred.right ==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right ==curr){
                    pred.right=null;
                    a.add(curr.val);
                    curr=curr.right;
                }
            }
            else{ //if currleft quesnt exist
                a.add(curr.val);
                curr=curr.right;
            }
        }
        List<Integer> b=new ArrayList<>(); //root1 ke sare eelment sort krdo morris
        curr=root2;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr) pred=pred.right;
                if(pred.right ==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right ==curr){
                    pred.right=null;
                    b.add(curr.val);
                    curr=curr.right;
                }
            }
            else{ //if currleft quesnt exist
                b.add(curr.val);
                curr=curr.right;
            }
        }
        List<Integer> ans=new ArrayList<>(); 
        merge(a,b,ans);
        return ans;
    }
}