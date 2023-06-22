class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        
        int[] prev=new int[2];
        
        for(int i=n;i>=0;i--){
            
            int[] curr=new int[2];
            
            for(int buy=0;buy<2;buy++){
                
                if(i==prices.length) curr[buy]=0;
                else{
                    int profit=Integer.MIN_VALUE;

                    if(buy==1){
                        profit=Math.max(-prices[i]+ prev[0], prev[1]);
                    }else{
                         profit=Math.max(prices[i]-fee+ prev[1], prev[0]); 
                    }

                    curr[buy]=profit;
                }
                
                
                
            }
            prev=curr;
            
        }
        
        return prev[1]; 
    }
    
}