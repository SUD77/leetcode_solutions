class Solution {
    public int concatenatedBinary(int n) {
       
         int digits = 0, MOD = 1000000007;
        long result = 0;
        for(int i = 1; i <= n; i++){
			/* if "i" is a power of 2, then we have one additional digit in
			   its the binary equivalent compared to that of i-1 */
            if((i & (i - 1)) == 0) digits++; 
            result = ((result << digits) + i) % MOD;
        }
        
        return (int) result;
    }
}