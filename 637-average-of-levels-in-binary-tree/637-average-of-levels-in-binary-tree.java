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
    public List<Double> averageOfLevels(TreeNode root) {
        
        //will store BFS of the Binary tree
        List<List<Integer>> result=new ArrayList<>();
        
        //final result
        List<Double> finalResult=new ArrayList<Double>();
        
        //this function will return result having level order of BT
        solUtil(root,result);
        
        
        //Iterate through result to find the avg of lists (levels) present 
        for(List<Integer> x:result){
            int len=x.size();
            Double sum=0.0;
            
            for(Integer y:x){
                sum+=y;
            }
            Double avg=sum/len;
            finalResult.add(avg);
        }
        
        return finalResult;
    }
    
    //Level order traversal of Binary Tree (BFS)
    public void solUtil(TreeNode root,List<List<Integer>> result){
        
        if(root==null) return;
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            List<Integer> curr=new ArrayList<>();
            
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
            
            result.add(curr);
        }
    }
}