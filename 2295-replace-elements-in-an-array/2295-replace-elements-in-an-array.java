class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        HashMap<Integer,Integer> temp=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            temp.put(nums[i],i);
        }
        for(var i:operations){
            nums[temp.get(i[0])]=i[1];
            temp.put(i[1],temp.get(i[0]));
        }
        
        return nums;
    }
}