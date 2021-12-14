class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Map<Integer,Integer> temp=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(temp.get(nums[i])!=null) {
				temp.put(nums[i], temp.get(nums[i])+1);
			}else {
				temp.put(nums[i], 1);
			}
        }
        
        for(int i=0;i<nums.length;i++){
            if(temp.get(nums[i])>1){
                return true;
            }
        }
        
        return false;
        
    }
}