class Solution {
    public int maxCoins(int[] nums) {
        
        int n=nums.length;
        
        /* We need to add 1 at the front and the back. 
        So, creating new array for it. 
        */
        
        // start : creating new aray
        
        int i=0;
        int[] tempNums=new int[n+2];
        tempNums[i++]=1;
        
        for(int x:nums){
            tempNums[i++]=x;
        }
        
        tempNums[i]=1;
        
        // end
        
        int[][] dp=new int[n+1][n+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(1,n,tempNums,dp);
    }
    
    public int solUtil(int i,int j,int[] nums,int[][] dp){
        
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int maxi=Integer.MIN_VALUE;
        
        for(int ind=i;ind<=j;ind++){
            
            int cost=nums[i-1] * nums[ind] * nums[j+1] + solUtil(i,ind-1,nums,dp) + solUtil(ind+1,j,nums,dp);
            
            maxi=Math.max(maxi,cost);
        }
        
        return dp[i][j]=maxi;
    }
}