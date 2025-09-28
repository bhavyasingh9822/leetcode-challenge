/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static void serializeHelper(TreeNode root,StringBuilder result){
        if(root == null) return;

        result.append(root.val).append(",");
        serializeHelper(root.left,result);
        serializeHelper(root.right,result);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder("");
        if(root == null) return result.toString();

        serializeHelper(root,result);
        return result.toString();
    }

    public static TreeNode helperTreeBuilder(TreeNode root,int data){
        if(root == null) return new TreeNode(data);

        if(data <= root.val){ //left subtree
            if(root.left == null) root.left = new TreeNode(data);
            else root.left = helperTreeBuilder(root.left,data);
        }
        else{ //right subtree
            if(root.right == null) root.right = new TreeNode(data);
            else root.right = helperTreeBuilder(root.right,data);
        }
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        if(len == 0)return null;

        String temp[] = data.split(",");
        int n = temp.length;
        TreeNode root = new TreeNode(Integer.parseInt(temp[0]));

        for(int i =1;i<n;i++){
            int val = Integer.parseInt(temp[i]);
            helperTreeBuilder(root,val);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;