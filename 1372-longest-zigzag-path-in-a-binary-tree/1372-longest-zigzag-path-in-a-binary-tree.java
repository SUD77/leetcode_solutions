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

/*
For understanding : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/discuss/534418/JavaC%2B%2B-DFS-Solution-with-comment-O(N)-Clean-code

*/
class Solution {
    public int longestZigZag(TreeNode root) {
        int[] longestPath={0};
        
        solUtil(root,true,0,longestPath);
        solUtil(root,false,0,longestPath);
        
        return longestPath[0];
    }
    
    public void solUtil(TreeNode node,boolean dir,int path,int[] longestPath){
        
        if(node==null) return;
        
        longestPath[0]=Math.max(longestPath[0],path);
        
        if(dir){
           solUtil(node.left,!dir,path+1,longestPath);
           solUtil(node.right,dir,1,longestPath);
        }else{
            solUtil(node.right,!dir,path+1,longestPath);
            solUtil(node.left,dir,1,longestPath);
        }
    }
}