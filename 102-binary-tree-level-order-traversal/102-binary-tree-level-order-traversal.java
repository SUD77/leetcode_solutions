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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        List<List<Integer>> result=new ArrayList<>();
        
        solUtil(root,result);
        
        return result;
        
        
    }
    
    public void solUtil(TreeNode root,List<List<Integer>> result){
        
        if(root==null) return;
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            List<Integer> curr=new ArrayList<>();
            int len=q.size();
            
            for(int i=0;i<len;i++){
                TreeNode currNode=q.poll();  //removing the node from head and assigning to CurNode
                curr.add(currNode.val);
                
                //adding left node of CurrNode
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                
                //adding right node of CurrNode
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            
            
            result.add(curr);
        }
        
    }
    
   
}