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

class Pair{
    
    TreeNode node;
    int index;
    
    Pair(TreeNode node,int index){
        
        this.node=node;
        this.index=index;
    }
    
}


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        
        if(root==null) return 0;
        int BottomLeftValue=0;
        
        Queue<Pair> q=new LinkedList<>();
        
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            
            int minIndexAtCurrentLevel=q.peek().index;
            int size=q.size();
            
            for(int i=0;i<size;i++){
                
                int currIndex=q.peek().index-minIndexAtCurrentLevel;
                TreeNode node=q.peek().node;
                q.poll();
                
                if(i==0) BottomLeftValue=node.val;
                
                if(node.left!=null){
                    q.offer(new Pair(node.left,currIndex*2+1));
                }
                
                
                if(node.right!=null){
                    q.offer(new Pair(node.right,currIndex*2+2));
                }
                
            }
        }
        
        return BottomLeftValue;
    }
}