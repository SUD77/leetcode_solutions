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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
       
        if(depth==1){
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;
        }
        
        dfs(root,1,val,depth);
        return root;
    }
    
    private void dfs(TreeNode root,int depth,int v,int d){
        
        if(root==null) return;
        
        if(depth < d-1){
            dfs(root.left,depth+1,v,d);
            dfs(root.right,depth+1,v,d);
        } else{
            
            TreeNode tmp=root.left;
            root.left=new TreeNode(v);
            root.left.left=tmp;
            tmp=root.right;
            root.right=new TreeNode(v);
            root.right.right=tmp;
        }
        
    }
}