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
    
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        
        solUtil(root);
        return result;
        
    }
    
    
    public void solUtil(TreeNode root){
        if(root==null) return;
        
      
        
        solUtil(root.left);
        solUtil(root.right);
        result.add(root.val);
    }
}