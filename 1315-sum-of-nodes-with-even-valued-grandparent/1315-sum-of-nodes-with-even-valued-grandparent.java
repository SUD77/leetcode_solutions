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
    public int sumEvenGrandparent(TreeNode root) {
     
        return solUtil(root,-1,-1);
        
    }
    
    public int solUtil(TreeNode root,int parent,int grandP){
        
        if(root==null) return 0;
        
        int ans=0;
        
        if(grandP%2==0) {
           ans=root.val; 
        }
        
        grandP=parent;
        parent=root.val;
        
        return ans+solUtil(root.left,parent,grandP) + solUtil(root.right,parent,grandP);
        
    }
}