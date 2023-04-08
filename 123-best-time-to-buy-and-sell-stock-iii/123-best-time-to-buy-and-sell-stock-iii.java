//Space Optimization
// TC - O(n*2*2) 
// SC - O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        int[][] prev=new int[2][3];
        
        
        for(int i=n;i>=0;i--){
            
            int[][] curr=new int[2][3];
            
            for(int buy=0;buy<=1;buy++){
                
                for(int k=0;k<3;k++){
                    
                    if(k==0){
                        curr[buy][k]=0;
                    }else if(i==n){
                        curr[buy][k]=0;
                    }else{
                        int profit=0;
                        if(buy==1){
                            profit= Math.max(-prices[i] + prev[0][k], prev[1][k]);
                        }else{
                            profit= Math.max(prices[i] + prev[1][k-1], prev[0][k]); 
                        }

                        curr[buy][k]=profit;
                    }
                }
            }
            prev=curr;
            
        }
        
        return prev[1][2]; 
    }
    
}