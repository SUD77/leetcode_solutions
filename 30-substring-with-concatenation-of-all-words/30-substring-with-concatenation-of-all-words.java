class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        if(s == null || s.length() == 0 || words == null || words.length==0 )
            return new ArrayList<>();
        
        Map<String,Integer> freqMap=new HashMap<>();
        
        for(String word:words){
            freqMap.put(word,freqMap.getOrDefault(word,0)+1);
        }
        
        int wordLen=words[0].length();
        int wordsSize=words.length;
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<=s.length()-wordsSize * wordLen;i++){
            
            Map<String,Integer> seenWords=new HashMap<>();
            
            for(int j=0;j<wordsSize;j++){
                
                int wordIndex=i+j*wordLen;
                
                String word=s.substring(wordIndex,wordIndex + wordLen);
                
                if(!freqMap.containsKey(word)){
                    break;
                }
                
                seenWords.put(word,seenWords.getOrDefault(word,0)+1);
                
                if(seenWords.get(word) > freqMap.getOrDefault(word,0)){
                    break;
                }
                
                if(j+1 == wordsSize){
                    result.add(i);
                }
            }
        }
        
        return result;
    }
}