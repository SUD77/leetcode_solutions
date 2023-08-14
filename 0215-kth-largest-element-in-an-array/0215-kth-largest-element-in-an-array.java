class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        PriorityQueue<Integer> tempQ=new PriorityQueue<>(Collections.reverseOrder());

        for(int x:nums){
            tempQ.add(x);
        }

        while (k!=1){
            tempQ.poll();
            k--;
        }

        
        return tempQ.poll();
    }
}