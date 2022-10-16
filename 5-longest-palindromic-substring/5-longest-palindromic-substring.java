class Solution {
    public String longestPalindrome(String s) {
      
        int tempLen=0;
        int start=0;
        int end=0;
        
        //cbbd
        
        for(int i=0;i<s.length();i++){
        
            //i=1
            int len1 = expandCentre(s,i,i);  //s,1,1 - 1
            int len2 = expandCentre(s,i,i+1); // s,1,2  - 2
            
            tempLen=Math.max(len1,len2); // 2
            
            if(end-start+1 < tempLen){ 
                start=i-(tempLen-1)/2; // 1 - (2-1)/2 = 1-(1/2) = 1
                end=i+tempLen/2; //0 1+ 1 = 2 
            }
            
            
        }
       
        return s.substring(start,end+1);
        
        
    }
    
    public int expandCentre(String s, int middleIndex1,int middleIndex2){

        //0>=0 , 3<=3, c!=d
        while(middleIndex1>=0 && middleIndex2<=s.length()-1 && s.charAt(middleIndex1)==s.charAt(middleIndex2)){
            
            middleIndex1--; //0
            middleIndex2++; //3
        }
        
        //3-0-1
        return middleIndex2-middleIndex1-1;
        
    }
    
    // i=3, tempLen =5
    // 0 1 2 3 4 5 6 7  
    // z a b c b a q w
        
     // i=3, tempLen = 6   
    // 0 1 2 3 4 5 6 7 8 
    // z a b c c b a q w
  

}