class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n=cost.length;
        
        if(n==1) return cost[n-1];
        
        
        int firstStep=cost[0];
        int secondStep=cost[1];
        
        for(int i=2;i<=n;i++){
            
            int currStep=0;
            if(i==n){
                currStep=0+Math.min(firstStep,secondStep);
            }else{
                currStep=cost[i]+Math.min(firstStep,secondStep);
            }
            
            firstStep=secondStep;
            secondStep=currStep;
            
        }
        
        
        return secondStep;
    }
    

}