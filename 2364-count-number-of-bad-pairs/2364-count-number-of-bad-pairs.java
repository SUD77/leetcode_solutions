class Solution {
    public long countBadPairs(int[] nums) {
        
        HashMap<Integer,Integer> tempMap=new HashMap<>();
        
        long count=0;
        
        for(int i=0;i<nums.length;i++){
            
            int diff=i-nums[i];
            
            if(tempMap.containsKey(diff)){
                count+= (i - tempMap.get(diff));
            }else{
                count+= i;
            }
            
            tempMap.put(diff,tempMap.getOrDefault(diff,0) + 1);
        }
        
        return count;
    }
}