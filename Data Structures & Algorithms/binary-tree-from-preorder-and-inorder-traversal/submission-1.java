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
    int index = 0;
     Map<Integer,Integer> indices = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        //O(n2) solution
        /*int mid = -1;
        for(int i = 0; i< inorder.length;i++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        int [] leftPreorder = Arrays.copyOfRange(preorder,1,mid+1);
        int [] leftInorder = Arrays.copyOfRange(inorder,0,mid);
        root.left = buildTree(leftPreorder,leftInorder);
        int [] rightPreOrder =  Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int [] rightInorder = Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.right = buildTree(rightPreOrder,rightInorder);
        return root;
        */
        
       
        for(int i = 0; i< inorder.length;i++){
            indices.put(inorder[i],i);
        }
        return buildTree(preorder,0,inorder.length-1);
    }
    public TreeNode buildTree(int [] preorder,int l , int r){
        if(l > r) return null;
        int root_val = preorder[index++];
        int mid = indices.get(root_val);
        TreeNode root = new TreeNode(root_val);
        root.left = buildTree(preorder,l,mid-1);
        root.right = buildTree(preorder,mid+1,r);
        return root;
    }
}
