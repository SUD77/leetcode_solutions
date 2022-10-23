class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Arrays.sort(nums);
        
        int[] res=new int[2];
        
        int freq[]=new int[nums.length+1];
        
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        
        for(int j=1;j<=nums.length;j++){
            if(freq[j]==2) res[0]=j;
            if(freq[j]==0) res[1]=j;
        }
        
        return res;
    }
}