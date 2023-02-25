class Solution {
    public int maxProfit(int[] prices) {
        
        int profit=Integer.MIN_VALUE;
        int currentMinEle=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            
            currentMinEle=Math.min(currentMinEle,prices[i]);
            profit=Math.max(profit, prices[i]-currentMinEle);
        }
        
        return profit;
         
    }
}