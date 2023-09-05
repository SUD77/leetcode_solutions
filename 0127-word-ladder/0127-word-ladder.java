class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
         Set<String> set=new HashSet<>();

         set.addAll(wordList);
        
        Deque<Pair> dq=new LinkedList<>();
        
        dq.addLast(new Pair(beginWord,1));
        int ans=0;
        
        while(!dq.isEmpty()){
            
            Pair pair=dq.pollFirst();
            
            String curWord=pair.word;
            int curLevel=pair.level;
        
            if(curWord.equals(endWord)) {
                return curLevel;
            }
            
            StringBuilder sb=new StringBuilder(curWord);
            
            for(int i=0;i<curWord.length();i++){
                for(char ch='a';ch<='z';ch++){
                    sb.setCharAt(i,ch);
                    
                    String modCurWord=sb.toString();
                    
                    
                    if(set.contains(modCurWord)){
                        dq.addLast(new Pair(modCurWord,curLevel+1));
                        set.remove(modCurWord);
                    }
                    
                }
                
               sb=new StringBuilder(curWord);
            }
        }
        
        return ans;
    }
    
    class Pair{
        
        String word;
        int level;
        
        public Pair(String word,int level){
            this.word=word;
            this.level=level;
        }
    }
}