class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
//         int left=0;
//         int maxLength=0;
//         int right=0;
//         Set<Character> temp=new HashSet<>();

//         while(right<s.length()){

//            if(!temp.contains(s.charAt(right))){
//                temp.add(s.charAt(right));
//                maxLength=Math.max((right-left+1),maxLength);
//                right++;
//            }else {
//                while (temp.contains(s.charAt(right))){
//                    temp.remove(s.charAt(left));
//                    left++;
//                }
//            }

//         }
        
        
        
        int left=0;
        int maxLength=0;
        int right=0;
        Map<Character,Integer> temp=new HashMap<>();

        while(right<s.length()){

           if(temp.containsKey(s.charAt(right)))
               left=Math.max(temp.get(s.charAt(right))+1,left);
               
               
            temp.put(s.charAt(right),right);
            maxLength=Math.max((right-left+1),maxLength);
            right++;

        }
        
        return maxLength;
    }
}