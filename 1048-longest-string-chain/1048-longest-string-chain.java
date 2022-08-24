class Solution {
    public int longestStrChain(String[] words) {
        
        HashMap<String,Integer> dp=new HashMap<>();
        
        int ans=0;
        
        Arrays.sort(words, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o1.length()-o2.length();
             }
         });
        
        for(String word:words){
            
            dp.put(word,1);
            
            for(int i=0;i<word.length();i++){
                
                StringBuilder current=new StringBuilder(word);
                String predecessor = current.deleteCharAt(i).toString();
               
                if(dp.containsKey(predecessor))
                    dp.put(word,Math.max(dp.get(word),dp.get(predecessor)+1));
                
            }
            ans=Math.max(ans,dp.get(word));
        }
        
        return ans;
    }
}