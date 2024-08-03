class Solution {
    public int longestConsecutive(int[] nums) {
        
        int count=0;
        int n=nums.length;
        
        HashSet<Integer> set=new HashSet<>();
        
        for(int x:nums){
            set.add(x);
        }
        
        for(int i=0;i<n;i++){
            
            if(!set.contains(nums[i]-1)){
                
                int curStreak=1;
                int curNum=nums[i];
                
                while(set.contains(curNum+1)){
                    curStreak++;
                    curNum++;
                }
                
                count=Math.max(curStreak,count);
            }
        }
        
        return count;
    }
}