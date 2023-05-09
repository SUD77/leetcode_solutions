class Solution {
    public int arrangeCoins(int n) {
        
        long low=1;
        long high=n;
        
        while(low+1<high){
            
            long mid=low + (high - low)/2;
            
            if(coinsInRow(mid)<=n){
                low=mid;
            }else{
                high=mid;
            }
            
          
        }
        
        return (int)low;
    }
    
    public long coinsInRow(long mid){
        return mid* (mid + 1) /2;
    }
}