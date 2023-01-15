/*
https://leetcode.com/problems/count-the-number-of-good-subarrays/discuss/3052742/Two-Pointers-or-Java
*/

class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int l = 0;
        long ans=0;
        for(int r=0;r<n;r++) {
            int curr = nums[r];
            int currFreq = freq.getOrDefault(nums[r], 0);
            count+=currFreq;
            freq.put(nums[r], currFreq+1);
            while(count >= k) {
                count = count - (freq.get(nums[l])-1);
                freq.put(nums[l], freq.get(nums[l])-1);
                l++;
            }
            ans+=l;
        }
        return ans;
    }
}