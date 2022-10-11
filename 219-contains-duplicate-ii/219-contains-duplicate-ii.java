class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer,Integer> temp=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(temp.containsKey(nums[i])){
                int j=temp.get(nums[i]);
                if(Math.abs(i-j)<=k) return true;
            }
            temp.put(nums[i],i);
        }
        
        return false;
    }
}