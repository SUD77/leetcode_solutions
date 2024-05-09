class Solution {
    public int majorityElement(int[] nums) {
        
        int ans=0;
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        int tempCount=0;
        
        for(int x:nums){
            if(map.get(x)>=tempCount){
                tempCount=map.get(x);
                ans=x;
            }
        }
        
        return ans;
        
    }
}