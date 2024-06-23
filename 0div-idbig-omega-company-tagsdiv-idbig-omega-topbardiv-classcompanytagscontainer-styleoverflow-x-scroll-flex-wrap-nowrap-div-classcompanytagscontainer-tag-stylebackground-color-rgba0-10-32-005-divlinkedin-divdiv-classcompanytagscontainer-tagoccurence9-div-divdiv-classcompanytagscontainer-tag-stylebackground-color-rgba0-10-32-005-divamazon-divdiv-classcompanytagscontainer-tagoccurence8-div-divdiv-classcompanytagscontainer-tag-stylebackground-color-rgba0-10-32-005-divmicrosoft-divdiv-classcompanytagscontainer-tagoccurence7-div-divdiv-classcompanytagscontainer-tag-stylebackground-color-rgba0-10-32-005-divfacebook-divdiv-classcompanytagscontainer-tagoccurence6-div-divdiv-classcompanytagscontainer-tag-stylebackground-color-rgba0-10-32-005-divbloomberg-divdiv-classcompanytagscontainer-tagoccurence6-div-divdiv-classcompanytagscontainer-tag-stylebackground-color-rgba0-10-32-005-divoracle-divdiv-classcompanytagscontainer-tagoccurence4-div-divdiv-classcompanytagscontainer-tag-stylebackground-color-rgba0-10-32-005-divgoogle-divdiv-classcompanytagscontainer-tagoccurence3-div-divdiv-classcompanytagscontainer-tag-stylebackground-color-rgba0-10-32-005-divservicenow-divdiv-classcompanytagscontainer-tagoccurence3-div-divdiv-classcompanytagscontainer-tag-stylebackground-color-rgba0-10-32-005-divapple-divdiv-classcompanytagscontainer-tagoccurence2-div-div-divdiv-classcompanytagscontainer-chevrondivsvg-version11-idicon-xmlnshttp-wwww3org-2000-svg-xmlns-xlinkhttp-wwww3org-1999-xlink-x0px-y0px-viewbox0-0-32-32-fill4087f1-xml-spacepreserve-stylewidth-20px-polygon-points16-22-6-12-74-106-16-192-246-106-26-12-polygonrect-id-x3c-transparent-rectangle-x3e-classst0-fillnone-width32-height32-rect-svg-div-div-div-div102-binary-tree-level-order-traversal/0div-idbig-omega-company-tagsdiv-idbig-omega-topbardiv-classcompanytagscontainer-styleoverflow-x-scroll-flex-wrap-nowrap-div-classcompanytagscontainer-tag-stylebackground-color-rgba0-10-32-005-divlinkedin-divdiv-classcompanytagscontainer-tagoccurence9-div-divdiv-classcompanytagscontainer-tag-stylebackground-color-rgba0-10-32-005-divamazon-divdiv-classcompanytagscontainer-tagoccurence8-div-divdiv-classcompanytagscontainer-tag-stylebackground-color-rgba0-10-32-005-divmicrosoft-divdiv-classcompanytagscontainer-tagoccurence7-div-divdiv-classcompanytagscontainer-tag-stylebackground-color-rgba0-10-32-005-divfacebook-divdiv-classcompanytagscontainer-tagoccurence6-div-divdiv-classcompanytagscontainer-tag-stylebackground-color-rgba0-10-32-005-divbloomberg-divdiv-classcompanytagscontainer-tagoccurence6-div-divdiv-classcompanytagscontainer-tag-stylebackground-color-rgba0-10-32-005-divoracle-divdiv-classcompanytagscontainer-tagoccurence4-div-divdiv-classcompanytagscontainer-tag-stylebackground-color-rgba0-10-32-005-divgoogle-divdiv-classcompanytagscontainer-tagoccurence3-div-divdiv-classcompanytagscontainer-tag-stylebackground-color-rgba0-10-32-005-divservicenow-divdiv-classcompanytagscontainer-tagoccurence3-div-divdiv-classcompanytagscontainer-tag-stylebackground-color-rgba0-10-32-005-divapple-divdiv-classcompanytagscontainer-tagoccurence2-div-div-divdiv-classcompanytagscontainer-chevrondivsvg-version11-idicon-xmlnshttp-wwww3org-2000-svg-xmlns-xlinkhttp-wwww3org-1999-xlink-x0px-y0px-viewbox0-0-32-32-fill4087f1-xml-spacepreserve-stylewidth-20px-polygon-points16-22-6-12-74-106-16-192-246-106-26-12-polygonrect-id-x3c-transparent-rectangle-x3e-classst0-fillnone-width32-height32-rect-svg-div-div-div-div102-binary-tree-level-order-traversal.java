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
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            List<Integer> tempList=new ArrayList<>();
            int len=q.size();
            
            for(int i=0;i<len;i++){
                TreeNode cur=q.poll();
                tempList.add(cur.val);
                
                if(cur.left!=null){
                    q.add(cur.left);
                }
                
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            
            result.add(tempList);
        }
    }
}