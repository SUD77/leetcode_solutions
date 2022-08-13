class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        
        int[][] dp=new int[n+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,0);
        }
        

        for(int index=n-1;index>=0;index--){
            
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
                
                int len=dp[index+1][prevIndex+1];
                
                if(prevIndex == -1 || nums[index]>nums[prevIndex]){
                    len=Math.max(len,1+dp[index+1][index+1]);
                }
                
                dp[index][prevIndex+1]=len;
            }
        }
        
        // for(int[] x:dp){
        //     System.out.println(Arrays.toString(x));
        // }
        
        return dp[0][0];
    }
    

}