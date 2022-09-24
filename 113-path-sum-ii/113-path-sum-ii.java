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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        
        
        solUtil(root,targetSum,temp,result);
        
        return result;
    }
    
    public void solUtil(TreeNode root, int targetSum,List<Integer> temp,List<List<Integer>> result){
        
        
        if(root==null) return;
        temp.add(root.val);
        
        if(root.left==null && root.right==null){
            
            if(root.val==targetSum)
                result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(root.left!=null){
            solUtil(root.left,targetSum-root.val,temp,result);
            temp.remove(temp.size()-1);
        }
        
        if(root.right!=null){
            solUtil(root.right,targetSum-root.val,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}