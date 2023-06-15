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
    public int maxLevelSum(TreeNode root) {
        int sumL=Integer.MIN_VALUE;
        int level=1;
        int ans=0;
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size=q.size();
            int curSum=0;
            
            for(int i=0;i<size;i++ ){
                
                TreeNode node=q.poll();
                curSum+=node.val;
                
                if(node.left!=null) {
                    q.add(node.left);
                }
            
                if(node.right!=null) {
                    q.add(node.right);
                }
                
            }

            if(curSum>sumL){
                sumL=curSum;
                ans=level;
            }
            
            level++;
            
            
        }
        
        return ans;
    }
}