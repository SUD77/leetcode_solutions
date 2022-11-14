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
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        
         int count=0;
        
        if(root==null) return count;
        
        queue.offer(root);
        
       
        
        while(!queue.isEmpty()){
            
            int levelNum=queue.size();
            
            List<Integer> subList=new LinkedList<Integer>();
            
            for(int i=0;i<levelNum;i++){
                
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                
                subList.add(queue.poll().val);
            }
            
            int[] tempArr1=new int[subList.size()];
            int i1=0;
            for(Integer x:subList){
                tempArr1[i1++]=x;
            } 
            
            count+=minSwaps(tempArr1);
          
            
          
        }
         
        return count;
    }
    
    
     public static int minSwaps(int[] arr1) {
        int n = arr1.length;
        Pair[]arr = new Pair[n];
        for (int i = 0; i < n; i++) {
          arr[i] = new Pair(arr1[i], i);
        }
        Arrays.sort(arr);
        int ans = 0;
        boolean[]vis = new boolean[n];
        for (int i = 0; i < n; i++) {
          if (vis[i] == true || arr[i].idx == i) {
            continue;
          }
          int clen = 0;
          int j = i;
          while (vis[j] == false) {
            vis[j] = true;
            clen++;
            j = arr[j].idx;
          }
          ans += (clen - 1);
        }
        return ans;
  }

      private static class Pair implements Comparable< Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
          this.val = val;
          this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
          return this.val - o.val;
        }
      }
    
    
}