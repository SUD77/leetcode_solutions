class Solution {
    
    
    public int numFactoredBinaryTrees(int[] nums) {
        
        Arrays.sort(nums);
        long count=0;
        
        HashMap<Integer,Long> map=new HashMap<>();
        
        map.put(nums[0],(long)1);
        
        for(int j=1;j<nums.length;j++){
            
            long possible =1;
            for(int i=0;i<j;i++){
                
                if(nums[j]%nums[i]==0 && map.containsKey(nums[j]/nums[i]) ){
                    
                    
                    possible += map.get(nums[i]) * (map.get(nums[j]/nums[i]));
                        
                    
                }
            }
            map.put(nums[j],possible);
        }
        

        for(Integer n:map.keySet()){
            count = (count+map.get(n)) % ((int) Math.pow(10, 9) + 7);
        }
        
        
        return (int)(count ) ;
    }
}