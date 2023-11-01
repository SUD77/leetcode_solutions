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
    
    Map<Integer,Integer> temp=new HashMap<>();
    
    public int[] findMode(TreeNode root) {
    
        int maxV=Integer.MIN_VALUE;
        List<Integer> res=new ArrayList<>();
        int size=0;
        dfs(root);
        
        for(Map.Entry x:temp.entrySet()){
            int val=(int)x.getValue();
            
            maxV=Math.max(maxV,val);
        }
        
        for(Map.Entry x:temp.entrySet()){
            int val=(int)x.getValue();
            int key=(int)x.getKey();
            
            if(val==maxV){
                size++;
                res.add(key);
            }
            
        }
        
        int[] result=new int[size];
        int i=0;
        
        for(int x:res){
            result[i++]=x;
        }
        
        
        
        return result;
        
        
    }
    
    public void dfs(TreeNode root){
        
        if(root==null) return;
        
        dfs(root.left);
        temp.put(root.val,temp.getOrDefault(root.val,0)+1);
        dfs(root.right);
    }
}