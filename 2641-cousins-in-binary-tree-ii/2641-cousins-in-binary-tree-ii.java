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
1. first preCompute the level SUM
2. Then again perform bfs and subtract sibling value.

*/
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        
         List<Integer> level = new ArrayList<>();
        
        if(root == null) return null;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int len = q.size();
            
           
            int totalLevelSum=0;
            
            for(int i=0 ; i<len; i++){
                
                TreeNode temp = q.remove();
                
                //level.add(temp.val);
                totalLevelSum+=temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                
            }
            level.add(totalLevelSum);
            
            
        }
        
        // for(List<Integer> x:ans){
        //     System.out.println(x);
        // }
        
        q.clear();
        
        q.add(root);
        int currLevel=-1;
        
        while(!q.isEmpty()){
            
            currLevel++;
            
            int len=q.size();
            
            for(int i=0;i<len;i++){
                int sumOfSibling=0;
                
                TreeNode currNode=q.remove();
                
                if(currLevel==0 || currLevel==1){
                    currNode.val=0;
                }
                
                //add the value of left child
                if(currNode.left!=null){
                    sumOfSibling+= currNode.left.val;
                    q.add(currNode.left);
                }
                
                 //add the value of left child
                if(currNode.right!=null){
                    sumOfSibling+= currNode.right.val;
                    q.add(currNode.right);
                }
                
                if(currLevel>=1){
                    
                    if(currNode.left!=null){
                        currNode.left.val=level.get(currLevel+1)-sumOfSibling;
                    }
                
                 
                    if(currNode.right!=null){
                         currNode.right.val=level.get(currLevel+1)-sumOfSibling;
                    }
                }
            }
            
        }
        
        
    
        return root;
    }
    
}