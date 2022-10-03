class Solution {
    public int minCost(String colors, int[] cost) {
        
        int result=0, maxCost=0, sumCost=0, n=colors.length();
        
        for(int i=0;i<n;++i){
            
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                result+=sumCost-maxCost;
                sumCost=maxCost=0;
            }
            sumCost+=cost[i];
            maxCost=Math.max(maxCost,cost[i]);
        }
        
        result+=sumCost-maxCost;
        return result;
    }
}