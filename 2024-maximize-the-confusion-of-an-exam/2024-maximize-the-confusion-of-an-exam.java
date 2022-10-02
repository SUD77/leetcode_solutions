class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
       
        int n=answerKey.length();
        
        int low=1,high=n,answer=1;
        
        while(low<=high){
            
            int mid=(high+low)>>1;
            
            if(canReplace(answerKey,mid,k)){
                
                answer=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        
        return answer;
    }
    
    public Boolean canReplace(String s,int len,int k){
        
        int fCount=0, tCount=0;
        
        for(int i=0;i<len;i++){
            
            if(s.charAt(i)=='T') tCount++;
            if(s.charAt(i)=='F') fCount++;
        }
        
        if(tCount<=k || fCount<=k) return true;
        
        int low=0,high=len-1;
        
        while(high<s.length()-1){
            
            if(s.charAt(low)=='T') tCount--;
            if(s.charAt(low)=='F') fCount--;
            
            low++;
            high++;
            
            if(s.charAt(high)=='T') tCount++;
            if(s.charAt(high)=='F') fCount++;
            
            if(tCount <=k || fCount <=k) return true;
        }
        
        return false;
    }
}