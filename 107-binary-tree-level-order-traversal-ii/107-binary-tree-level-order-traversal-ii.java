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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        
        solUtil(root,result);
        
        //reversing the list
        Collections.reverse(result);
        
        
        
        return result;
    }
    
    public void solUtil(TreeNode root,List<List<Integer>> result){
        
        if(root==null) return;
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            //Temporary list to hold the level of BT
            List<Integer> curr=new ArrayList<Integer>();
            
            int len=q.size();
            
            for(int i=0;i<len;i++){
                
                TreeNode currNode=q.poll();
                curr.add(currNode.val);
                
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            
            //Adding the Temporary list to final List
            result.add(curr);
        }
    }
}