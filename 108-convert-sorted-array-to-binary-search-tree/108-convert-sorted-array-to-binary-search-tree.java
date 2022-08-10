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
    
    
    public TreeNode sortedArrayToBST(int[] nums) {
       
        if(nums.length==0) return null;
        
        return solUtil(nums,0,nums.length-1);
    }
    
    public TreeNode solUtil(int[] nums,int start,int endpoint){
        
        if(start>endpoint) return null;
        
        int middle = start + (endpoint - start) /2;
        TreeNode node=new TreeNode(nums[middle]);
        
        node.left=solUtil(nums,start,middle-1);
        node.right=solUtil(nums,middle+1,endpoint);
        
        return node;
    }
}