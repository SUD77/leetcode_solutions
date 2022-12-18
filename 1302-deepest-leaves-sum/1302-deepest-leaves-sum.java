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
    
    int[] h=new int[1];
    
    public int deepestLeavesSum(TreeNode root) {
        
        maxHeight(root);
        
        int ans=sumOfLeaves(root,1);
        
        return ans;
    }
    
    public int maxHeight(TreeNode root){
        
       if(root==null) return 0;
        
        return h[0]=Math.max(1+maxHeight(root.left),1+maxHeight(root.right));
        
    }
    
    public int sumOfLeaves(TreeNode root,int depth){
        
        if(root==null ) return 0;
        
        if(root.left==null && root.right==null && depth==h[0]){
            return root.val;
        }
        
        return sumOfLeaves(root.left,depth+1) + sumOfLeaves(root.right,depth+1); 
        
    }
}