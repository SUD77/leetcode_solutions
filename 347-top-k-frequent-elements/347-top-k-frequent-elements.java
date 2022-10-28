class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> temp=new HashMap<>();
        
        for(int n:nums){
            temp.put(n,temp.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        
        for(Map.Entry<Integer,Integer> entry:temp.entrySet()){
            maxHeap.add(entry);
        }
        
        int[] res=new int[k];
        int i=0;
        
        while(i<k){
            Map.Entry<Integer,Integer> entry=maxHeap.poll();
            res[i++]=entry.getKey();
        }
        
        return res;
    }
}