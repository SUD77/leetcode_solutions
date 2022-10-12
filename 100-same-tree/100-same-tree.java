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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        
        dfsUtil(p,l1);
        dfsUtil(q,l2);
        
        return l1.equals(l2);
    }
    
    public void dfsUtil(TreeNode p, List<Integer> x){
        
        if(p==null) {
            x.add(0);    
            return;
        }
        
        x.add(p.val);
        dfsUtil(p.left,x);
        dfsUtil(p.right,x);
    }
}