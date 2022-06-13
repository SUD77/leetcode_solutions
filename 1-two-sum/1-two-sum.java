class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        int[] result=new int[2];
        
        int i=0;
        int j=nums.length-1;
        
       
        HashMap<Integer,Integer> temp=new HashMap<>();
        
        for(i=0;i<=j;i++){
           
            int diff=target-nums[i];
            
            if(temp.containsKey(diff)){
                result[0]=i;
                result[1]=temp.get(diff);
                return result;
            }
            
            temp.put(nums[i],i);
        }
        
        return result;
    }
}