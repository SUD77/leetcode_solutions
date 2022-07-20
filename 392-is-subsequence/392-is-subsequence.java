class Solution {
    public boolean isSubsequence(String s, String t) {
       
        return checkSubsequence(t,s);
    }
    
    
    private boolean checkSubsequence(String inputString,String word){
        
        int prevCharIndex=0;
        
        for(char ch:word.toCharArray()){
            
            int index=inputString.indexOf(ch,prevCharIndex);
            
            if(index==-1) return false;
            
             prevCharIndex=index+1;
        }
        
      
        
        return true;
    }
}