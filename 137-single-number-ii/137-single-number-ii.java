class Solution {
    public int singleNumber(int[] nums) {
         Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            
            if(!temp.containsKey(nums[i])){
                temp.put(nums[i],1);
            }else{
                temp.put(nums[i],temp.get(nums[i])+1);
            }
        }
        System.out.println(temp);
        
        for(int x:nums){
            if(temp.get(x) == 1) return x;
        }
        
        return -1;
    }
}