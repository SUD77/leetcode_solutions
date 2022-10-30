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
    public int[] treeQueries(TreeNode root, int[] queries) {
        
        int n=queries.length;
       
        int[] ans=new int[n];
        
        Map<Integer,Integer> heightOfThisNode=new HashMap<>(); 
        findHeightOfEveryNode(root,heightOfThisNode);
        
        
        // size is +1, because node are from 1 to n, and we want to store particular node at its index in this array. For example, node value 2 should be at index 2. 
        int[] hightWithoutNode=new int[heightOfThisNode.size() + 1];
        findMaxHeightOfTreeWithoutThisNode(root,0,0,hightWithoutNode,heightOfThisNode);
          
        
        for(int i=0;i<n;i++){
            ans[i]=hightWithoutNode[queries[i]];
        }
        
        return ans;
    }
    
    public void findMaxHeightOfTreeWithoutThisNode(TreeNode node,int heightOfthisNodeFromRoot, int possibleMaxHeightOfTree, int[] hightWithoutNode, Map<Integer,Integer> heightOfThisNode ){
        
        if(node==null) return;
        
        int leftHeight= node.left==null ? 0 : heightOfThisNode.get(node.left.val);
        int rightHeight= node.right==null ? 0 : heightOfThisNode.get(node.right.val);
        
        /*
        1. Now, before this node, we will find the left and right cases.
        2. Here, we remove leftchild, then possible max height will be  right height + heihgt of this node from root. 
        
        */
        findMaxHeightOfTreeWithoutThisNode(node.left, heightOfthisNodeFromRoot+1, Math.max( possibleMaxHeightOfTree, rightHeight + heightOfthisNodeFromRoot ), hightWithoutNode, heightOfThisNode);
        findMaxHeightOfTreeWithoutThisNode(node.right, heightOfthisNodeFromRoot+1, Math.max( possibleMaxHeightOfTree, leftHeight + heightOfthisNodeFromRoot ), hightWithoutNode, heightOfThisNode);
        
        
        /*
         - saving the max value of height of tree, without this node. 
        */
        hightWithoutNode[node.val]=Math.max(heightOfthisNodeFromRoot-1, possibleMaxHeightOfTree);
        
        
        
    }
    
    public int findHeightOfEveryNode(TreeNode node,Map<Integer,Integer> mp) {
        
        if(node==null) return 0;
            
        int lh=findHeightOfEveryNode(node.left,mp);
        int rh=findHeightOfEveryNode(node.right,mp);
        
        mp.put(node.val,1+Math.max(lh,rh));
        
        return 1+Math.max(lh,rh);
    }
    
    
}