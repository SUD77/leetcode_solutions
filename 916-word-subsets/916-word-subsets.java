class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result=new ArrayList<>();
        
        int[] maxBfreq=new int[26];
        
        for(int i=0;i<words2.length;i++){
            
            String currentWord=words2[i];
            int[] charFreq=countChar(currentWord);
            
            for(int j=0;j<26;j++){
                maxBfreq[j]=Math.max(maxBfreq[j],charFreq[j]);
            }
            
        }
        
        for(int i=0;i<words1.length;i++){
            
            String currentWord=words1[i];
            int[] charCounts=countChar(currentWord);
            
            boolean valid=true;
            for(int j=0;j<26;j++){
                
                if(maxBfreq[j]>charCounts[j]){
                    valid=false;
                    break;
                }
            }
            
            if(valid) result.add(currentWord);
        }
        
        return result; 
    }
    
    public int[] countChar(String s){
        
        int[] result=new int[26];
        for(char c:s.toCharArray()){
            
            result[c-'a']++;
        }
        
        return result;
    }
}