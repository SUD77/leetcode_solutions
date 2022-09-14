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
    
    int count=0;
    int[] checkArr;
        
    //Arrays.fill(checkArr,0);
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        checkArr=new int[10];
        
        
        countFunc(root);
        
       
        return count;
        
    }
    
    public void countFunc(TreeNode root){
        
        if(root==null) return;
        
        checkArr[root.val]++;
        
        countFunc(root.left);
        countFunc(root.right);
        
        if(root.left==null && root.right==null){
            
            int oddOccurrenceCheck=0;
            
            for(int i=1;i<=9;i++){
                
                if(checkArr[i]%2!=0) oddOccurrenceCheck++;
            }
            
            if(oddOccurrenceCheck==1 || oddOccurrenceCheck==0) count++;
        }
        
        checkArr[root.val]--;
    }
}