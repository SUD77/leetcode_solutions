/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solUtil(root,p,q);
    }
    
    public TreeNode solUtil(TreeNode root, TreeNode p, TreeNode q){
        
        if(root.val==p.val || root.val==q.val) return root;
        
        if(p.val<root.val && q.val>root.val) return root;
        if(q.val<root.val && p.val>root.val) return root;
        
        if(p.val<root.val && q.val<root.val) return solUtil(root.left,p,q);
        return solUtil(root.right,p,q);
    }
}