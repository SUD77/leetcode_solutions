//Space
// TC - O(n*2)
//SC - O(2)


class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        
        int[] prev=new int[2];  //took size n+2 as, i is going till i+2
        int[] prev2=new int[2];
        
        for(int i=n+1;i>=0;i--){
            
            int[] curr=new int[2];
            
            for(int buy=0;buy<2;buy++){
                
                if(i>=n) curr[buy]=0;
                else{
                    int profit=0;
                    if(buy==1){
                        profit=Math.max(-prices[i] + prev[0],prev[1]); 
                    }else{
                        
                        int sellNow=prices[i] + prev2[1];
                        int sellLater=prev[0];
                        profit=Math.max(sellNow,sellLater); 
                    }
                    
                    curr[buy]=profit;
                }
                
            }
            prev2=prev;
            prev=curr;
        }
        return prev[1];
    }
    
}