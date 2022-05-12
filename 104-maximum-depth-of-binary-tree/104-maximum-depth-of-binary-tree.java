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
    public int maxDepth(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        solUtil(root,result);
        
        return result.size();
    }
    
    public void solUtil(TreeNode root,List<List<Integer>> result){
        
        if(root==null) return;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            List<Integer> temp=new ArrayList<>();
            int len=q.size();
            
            for(int i=0;i<len;i++){
                
                TreeNode curr=q.poll();
                temp.add(curr.val);
                
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            
            result.add(temp);
            
        }
    }
}