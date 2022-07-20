class Solution {
    public int numMatchingSubseq(String s, String[] words) {
       
        int count=0;
        
        for(String str:words){
            
            if(checkSubsequence(s,str)==true) count++;
        }
        
        return count;
       
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