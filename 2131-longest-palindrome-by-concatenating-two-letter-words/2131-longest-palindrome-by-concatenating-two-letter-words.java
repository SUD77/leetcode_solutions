/*
https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/discuss/1675693/JavaPython-3-One-pass-w-brief-explanation-and-analysis.
*/

class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String,Integer> wordsNotPaired=new HashMap<>();
        
        int pairs=0;
        int symmetricWords=0;
        
        for(String w:words){
            
            String reverse=new StringBuilder(w).reverse().toString();
            
            if(wordsNotPaired.getOrDefault(reverse,0)>0){
                ++pairs;
                wordsNotPaired.put(reverse, wordsNotPaired.getOrDefault(reverse, 0)-1);
                symmetricWords-=w.charAt(0)==w.charAt(1) ? 1:0;
            }else{
                
                wordsNotPaired.put(w, wordsNotPaired.getOrDefault(w, 0)+1);
                
                symmetricWords+=w.charAt(0)==w.charAt(1) ? 1:0;
            }
        }
        
        return 4 * pairs + (symmetricWords > 0 ? 2 : 0);
    }
}