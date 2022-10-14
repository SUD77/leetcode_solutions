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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        
        dfs(root1,s1);
        dfs(root2,s2);
        
        if(s1.size()!=s2.size()) return false;
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            
            int val1=s1.pop();
            int val2=s2.pop();
            
            System.out.println(val1);
            System.out.println(val2);
            
            if(val1!=val2){
                return false;
            }
        }
        
        
        return true;
    }
    
    public void dfs(TreeNode root,Stack<Integer> s){
        
        if(root==null) return;
        
        dfs(root.left,s);
        
        if(root.left==null && root.right==null)
            s.add(root.val);
        
        dfs(root.right,s);
    }
}