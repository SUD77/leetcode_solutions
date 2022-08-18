class Solution {
    public int arrangeCoins(int n) {
        
        long start =1;
        long end=n;
        
        long mid;
        long val;
        
        while(start<=end){
            
            mid=start+ (end - start)/2;
            val= mid * (mid + 1) /2;
            
            if(val == n){
                return (int) mid;
            }else if(val<n){
                start=mid+1;
            }else{
                end=mid-1;
            }
            
            
        }
        
        return (int) end;
    }
}