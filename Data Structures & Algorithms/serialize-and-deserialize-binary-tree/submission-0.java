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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root,res);
        return String.join(",",res);
    }

    private void dfsSerialize(TreeNode root, List<String> res){
        if(root == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left,res);
        dfsSerialize(root.right,res);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] vals = data.split(",");
        int [] index = {0};
        return dfsDeserialize(vals,index);
    }

    private TreeNode dfsDeserialize(String [] vals,int [] index){
        if(vals[index[0]].equals("N")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[index[0]]));
        index[0]++;
        node.left = dfsDeserialize(vals,index);
        node.right = dfsDeserialize(vals,index);
        return node;
    }
}
