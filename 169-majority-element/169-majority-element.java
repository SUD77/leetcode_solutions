class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> eleCount=new HashMap<>();
        
        for(int x:nums){
            eleCount.put(x,eleCount.getOrDefault(x,0)+1);
        }
        
        System.out.println(eleCount);
        
        for(int x:nums){
            if(eleCount.get(x)> (int) Math.floor(nums.length/2)) return x;
        }
         
        return -1;
        
    }
}