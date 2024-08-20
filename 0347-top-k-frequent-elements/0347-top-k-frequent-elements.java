class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int[] ans=new int[k];
        
        Map<Integer,Integer> freqMap=new HashMap<>();
        
        for(int x:nums){
            freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            maxHeap.add(entry);
        }
        
        int i=0;
        
        while(i<k){
            Map.Entry<Integer,Integer> entry=maxHeap.poll();
            ans[i++]=entry.getKey();
        }
        
        
        return ans;
    }
}