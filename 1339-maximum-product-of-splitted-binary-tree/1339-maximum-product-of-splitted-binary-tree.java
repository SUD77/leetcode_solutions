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
    
    static int MOD=(int) (1e9 + 7);
    
    int totalSum;
    long maximumProduct;
    
    public int maxProduct(TreeNode root) {
    
        //total sum of all the nodes in Tree
        totalSum=sumOfAllNodes(root);
        
        //Initializing maximumProduct
        maximumProduct=0l;
        
        getMaxProduct(root);
        
        return (int)(maximumProduct % MOD);
        
    }
    
    private int sumOfAllNodes(TreeNode root){
        
        if(root == null) return 0;
        
        return sumOfAllNodes(root.left) + sumOfAllNodes(root.right)  + root.val; 
    }
    
    private int getMaxProduct(TreeNode root){
        
        if(root == null) return 0;
        
        int subtree1Sum= getMaxProduct(root.left) + getMaxProduct(root.right) + root.val;
        
        int subtree2Sum=totalSum-subtree1Sum;
        
        maximumProduct = Math.max(maximumProduct, (long) subtree1Sum * subtree2Sum);
        
        return subtree1Sum;
    }
}