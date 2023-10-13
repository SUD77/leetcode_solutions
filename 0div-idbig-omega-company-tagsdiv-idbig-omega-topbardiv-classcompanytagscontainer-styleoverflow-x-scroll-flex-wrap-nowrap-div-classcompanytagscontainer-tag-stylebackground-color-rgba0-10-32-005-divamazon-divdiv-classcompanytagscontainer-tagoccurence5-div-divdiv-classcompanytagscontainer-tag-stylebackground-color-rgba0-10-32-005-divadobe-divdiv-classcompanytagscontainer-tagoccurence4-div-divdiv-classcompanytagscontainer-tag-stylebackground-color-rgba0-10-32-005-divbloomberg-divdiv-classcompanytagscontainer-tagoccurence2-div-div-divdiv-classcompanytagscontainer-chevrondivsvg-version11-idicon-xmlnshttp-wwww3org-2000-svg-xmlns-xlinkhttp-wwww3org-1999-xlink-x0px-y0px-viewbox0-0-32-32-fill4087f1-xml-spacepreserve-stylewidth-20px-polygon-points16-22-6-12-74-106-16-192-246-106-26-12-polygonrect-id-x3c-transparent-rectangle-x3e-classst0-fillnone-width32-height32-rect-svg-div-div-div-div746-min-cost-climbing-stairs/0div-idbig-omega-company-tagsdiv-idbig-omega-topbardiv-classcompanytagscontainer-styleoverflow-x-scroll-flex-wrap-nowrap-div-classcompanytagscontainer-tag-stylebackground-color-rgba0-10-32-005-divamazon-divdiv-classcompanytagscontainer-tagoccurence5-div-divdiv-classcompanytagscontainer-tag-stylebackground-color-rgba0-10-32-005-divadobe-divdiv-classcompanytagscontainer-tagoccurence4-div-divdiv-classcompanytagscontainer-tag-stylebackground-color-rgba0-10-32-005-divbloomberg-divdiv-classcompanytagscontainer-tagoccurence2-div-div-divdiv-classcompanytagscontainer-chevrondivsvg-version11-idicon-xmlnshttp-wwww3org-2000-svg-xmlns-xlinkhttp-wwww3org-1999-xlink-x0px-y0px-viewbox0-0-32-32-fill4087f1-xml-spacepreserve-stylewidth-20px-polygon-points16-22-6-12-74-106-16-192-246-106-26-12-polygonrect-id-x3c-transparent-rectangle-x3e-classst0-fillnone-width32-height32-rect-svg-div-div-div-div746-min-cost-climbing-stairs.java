class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n=cost.length;
 
        if(n==2) return Math.min(cost[0],cost[1]);
        
        int firstStep=0;
        int secondStep=Math.min(cost[0],cost[1]);
        int currStep=0;
        
        for(int i=3;i<=n;i++){
            
             int x=cost[i-1]+ secondStep;
             int y=cost[i-2]+ firstStep;
            
             
        
            
             currStep=Math.min(x,y);
            
            firstStep=secondStep;
            secondStep=currStep;
        }
        
        
        return currStep;
        
        
    }
    
   
}