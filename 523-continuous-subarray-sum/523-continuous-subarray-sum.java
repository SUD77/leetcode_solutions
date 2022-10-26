/*

    Running sum from first element to index i : sum_i. If we mod k, it will be some format like : sum_i = k * x + modk_1
    Running sum from first element to index j : sum_j. If we mod k, it will be some format like : sum_j = k * y + modk_2

If they have the same mod, which is modk_1 == modk_2, subtracting these two running sum we get the difference sum_i - sum_j = (x - y) * k = constant * k, and the difference is the sum of elements between index i and j, and the value is a multiple of k.

*/


class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       
        Map<Integer,Integer> map=new HashMap<>(){{put(0,-1);}};;
        
        int runningSum=0;
        
        for(int i=0;i<nums.length;i++){
            
            runningSum+=nums[i];
            
            if(k!=0) runningSum%=k;
            
            Integer prev=map.get(runningSum);
            
            if(prev != null){
                if(i-prev>1) return true;
            }
            else map.put(runningSum,i);
        }
        
        return false;
            
    }
}