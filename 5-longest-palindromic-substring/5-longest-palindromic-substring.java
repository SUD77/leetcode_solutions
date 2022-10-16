class Solution {
    public String longestPalindrome(String s) {
      
        int tempLen=0;
        int start=0;
        int end=0;
        
        for(int i=0;i<s.length();i++){
        
            // i, i for odd
            // i, i+1 for even
            int len1 = expandCentre(s,i,i);
            int len2 = expandCentre(s,i,i+1);
            
            tempLen=Math.max(len1,len2);
            
            if(end-start+1 < tempLen){
                start=i-(tempLen-1)/2;
                end=i+tempLen/2;
            }
            
            
        }
        
        return s.substring(start,end+1);
        
        
    }
    
    public int expandCentre(String s, int middleIndex1,int middleIndex2){

        while(middleIndex1>=0 && middleIndex2<=s.length()-1 && s.charAt(middleIndex1)==s.charAt(middleIndex2)){
            
            middleIndex1--;
            middleIndex2++;
        }
        
        
        return middleIndex2-middleIndex1-1;
        
    }
    

}