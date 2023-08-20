// from youtube
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        
        int maxFreq=0;
        int left=0;
        int n=nums.size();
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int right=0;right<n;right++){
            
            map.put(nums.get(right),map.getOrDefault(nums.get(right),0)+1);
            maxFreq=Math.max(maxFreq,map.get(nums.get(right)));
            
            if(right-left+1- maxFreq > k){
                map.put(nums.get(left),map.get(nums.get(left))-1);
                left++;
            }
        }
        
        
        return maxFreq;
    }
}