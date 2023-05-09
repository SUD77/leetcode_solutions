class Solution {
    public int arrangeCoins(int n) {
        
        long low=1;
        long high=n;
        
        long mid;
        long val;
        
        while(low+1<high){
            
            mid=low + (high - low)/2;
            val= mid* (mid + 1) /2;
            
            if(val<=n){
                low=mid;
            }else{
                high=mid;
            }
            
          
        }
        
        return (int)low;
    }
    
    // public long coinsInRow(long mid){
    //     return mid* (mid + 1) /2;
    // }
}