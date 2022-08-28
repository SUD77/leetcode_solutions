class Solution {
    public int minCost(int n, int[] cuts) {
        
        //temp is modified cut array , with 2 extra element added, at i=0 and last position
        int[] temp=new int[cuts.length+2];
        int c=cuts.length;
        
        //Start : Making new cuts array, i.e temp
        
        int i=0;
        temp[i++]=0;
        
        for(int x:cuts){
            temp[i++]=x;
        }
        
        temp[i]=n;
        
        //End 
        
        
        int[][] dp=new int[c+1][c+1];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        Arrays.sort(temp);
        
        return solUtil(1,c,temp,dp);
    }
    
    public int solUtil(int i,int j,int[] cuts,int[][] dp){
        
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int mini=Integer.MAX_VALUE;
        
        for(int ind=i;ind<=j;ind++){
            
            int cost=cuts[j+1] - cuts[i-1] + solUtil(i,ind-1,cuts,dp)+solUtil(ind+1,j,cuts,dp);
            mini=Math.min(mini,cost);
        }
        
        return dp[i][j]=mini;
        
    }
}