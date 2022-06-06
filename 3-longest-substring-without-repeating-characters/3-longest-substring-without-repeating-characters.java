class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int left=0;
        int maxLength=0;
        int right=0;
        Set<Character> temp=new HashSet<>();

        while(right<s.length()){

           if(!temp.contains(s.charAt(right))){
               temp.add(s.charAt(right));
               maxLength=Math.max((right-left+1),maxLength);
               right++;
           }else {
               while (temp.contains(s.charAt(right))){
                   temp.remove(s.charAt(left));
                   left++;
               }
           }

        }
        
        return maxLength;
    }
}