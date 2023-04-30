//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation/150089

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        List<List<Integer>> res=new ArrayList<>();
        
        int n1=nums1.length;
        int n2=nums2.length;
        
        if(n1==0 || n2==0) return res;
        
        for(int i=0;i<nums1.length && i<k;i++){
            q.offer(new int[]{nums1[i],nums2[0],0});
        }
        
        while(k-- > 0 && !q.isEmpty()){
            
            int[] curr=q.poll();
            
            List<Integer> tempArr=new ArrayList<>();
            
            tempArr.add(curr[0]);
            tempArr.add(curr[1]);
            
            res.add(tempArr);
            
            if(curr[2]==n2-1) continue;
          
            int index=curr[2]+1;
            q.offer(new int[]{curr[0], nums2[index],index});
            
        }
         
        return res;
    }
}