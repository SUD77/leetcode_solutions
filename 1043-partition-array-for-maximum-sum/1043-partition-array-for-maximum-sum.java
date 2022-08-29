class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n=arr.length;
        
        int[] dp=new int[n];
        
        Arrays.fill(dp,-1);
        
        return solUtil(0,arr,k,dp);
    }
    
    public int solUtil(int ind,int[] arr,int k,int[] dp){
        
        if(ind==arr.length) return 0;
        
        if(dp[ind]!=-1) return dp[ind];
        
        int len=0;
        int maxi=Integer.MIN_VALUE;
        
        int maxAns=Integer.MIN_VALUE;
        
        for(int j=ind; j<Math.min(ind+k,arr.length); j++){
            
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=len*maxi + solUtil(j+1,arr,k,dp);
            maxAns=Math.max(maxAns,sum);
        }
        
        return dp[ind]= maxAns;
        
    }
}