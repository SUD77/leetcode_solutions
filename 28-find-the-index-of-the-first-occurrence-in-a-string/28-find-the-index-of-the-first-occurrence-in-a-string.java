class Solution {
    public int strStr(String haystack, String needle) {
        
    if(needle.length()==0) return 0; 
        
        int len = needle.length();
        
        for(int i=0; i<haystack.length() ; i++) {
           
            if(haystack.charAt(i) == needle.charAt(0)){
                if(i + len-1  < haystack.length()) {
                    if (check(haystack.substring(i,i+len ) , needle) == true) return i;
                }
            }
            
        }
        return -1;
    }
    
    private static boolean check(String s1 , String s2) {
        return s1.equals(s2);    // -- checks for only content of two Strings..
        // return s1 == s2;  // == operator in Java checks for memory address
    }
}