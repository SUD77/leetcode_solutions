class KthLargest {

    private final PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private final int k;
    
    public KthLargest(int k, int[] nums) {
        
        this.k=k;
        
        for(Integer i:nums){
            minHeap.add(i);
            
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        
        minHeap.add(val);
        
        if(minHeap.size()>k){
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */