class Solution {
    public boolean closeStrings(String word1, String word2) {
       if(word1.length()!=word2.length())
            return false;
        
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        
        for(char c : word1.toCharArray())
            w1[c-'a']++;
        for(char c : word2.toCharArray())
            w2[c-'a']++;
        
        for(int i=0; i<26; i++){
            if(w1[i]==0 && w2[i]!=0)
                return false;
            if(w1[i]!=0 && w2[i]==0)
                return false;
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            map.put(w1[i],map.getOrDefault(w1[i],0)+1);
        }
        
        for(int i=0; i<26; i++){
            if(!map.containsKey(w2[i]))
                return false;
            map.put(w2[i],map.get(w2[i])-1);
            if(map.get(w2[i])==0)
                map.remove(w2[i]);
        }
        
        return map.isEmpty();
    }
}