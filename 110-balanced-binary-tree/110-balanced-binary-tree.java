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
    public boolean isBalanced(TreeNode root) {
        int ans = maxHeight(root);
        if(ans == Integer.MAX_VALUE) return false;
        return true;
    }
    private static int maxHeight(TreeNode root){
        if(root == null ) return 0;

        int lh = maxHeight(root.left);
        if(lh==Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        int rh = maxHeight(root.right);
        if(rh==Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(Math.abs(lh - rh) > 1) return Integer.MAX_VALUE;

        return 1 + Math.max(lh , rh);
    }
}