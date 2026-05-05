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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        if(root == null) return res;
        nodes.add(root);
        while(!nodes.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int queueSize = nodes.size();
            for(int i = queueSize; i > 0;i--){
                TreeNode temp = nodes.poll();
                list.add(temp.val);
                if(temp.left != null){
                    nodes.add(temp.left);
                }
                if(temp.right != null){
                    nodes.add(temp.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
