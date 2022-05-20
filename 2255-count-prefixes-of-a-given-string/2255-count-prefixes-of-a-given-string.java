class Solution {
    public int countPrefixes(String[] words, String s) {
        
        int result=0;
        for(String x:words){
            if(s.startsWith(x))
                result++;
        }
        
        return result;
    }
}