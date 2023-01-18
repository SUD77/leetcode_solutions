class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int oneCount = 0;
        int zeroToOnes = 0;
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        
        for(; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '0'){
                zeroToOnes++;
            }
            else {
                oneCount++;
            }
            if(zeroToOnes > oneCount) {
                zeroToOnes = oneCount;
            }
        }
        
        return zeroToOnes;
    }
}