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
    
    
    public int minDepth(TreeNode root) {
        
        //If root is empty, return 0
        if(root==null){
            return 0;
        }
        
        //To use BFS, we will use Queue
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        //Level will count nodes basically.
        int level=1;
        
        while(!q.isEmpty()){
            
            int len=q.size();
            
            for(int i=0;i<len;i++){
                
                TreeNode curr=q.poll();
                
                if(curr.left==null && curr.right==null){
                    return level;
                }
                
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            
            level++;
        }
        
        return level;
    }
   
    
}