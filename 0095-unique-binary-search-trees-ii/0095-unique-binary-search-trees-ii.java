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

//Amazing solution on youtube  : https://www.youtube.com/watch?v=qOItdXuTZGo&t=1158s&ab_channel=Pepcoding
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solUtil(1,n);
    }
    
    public List<TreeNode> solUtil(int start,int end){
        
        if(start>end){
            List<TreeNode> base=new ArrayList<>();
            base.add(null);
            return base;
        }
        
        List<TreeNode> ans=new ArrayList<>();
        
        for(int root=start;root<=end;root++){
            List<TreeNode> left=solUtil(start,root-1);
            List<TreeNode> right=solUtil(root+1,end);
            
            for(TreeNode l:left){
                for(TreeNode r:right){
                    
                    TreeNode tempRoot=new TreeNode(root);
                    
                    tempRoot.left=l;
                    tempRoot.right=r;
                    
                    ans.add(tempRoot);
                }
            }
        }
        
        
        return ans;
    }
}