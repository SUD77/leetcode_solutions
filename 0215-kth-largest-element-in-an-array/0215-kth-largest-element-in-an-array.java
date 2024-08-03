class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(int x:nums){
            pq.add(x);
        }
        
        while(k>1){
            pq.poll();
            k--;
        }
        
        return pq.poll();
    }
}