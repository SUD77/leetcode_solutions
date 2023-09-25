class Solution {
    public char findTheDifference(String s, String t) {

        int codeS=0;
        int codeT=0;
        
        for(int i=0;i<s.length(); i++) codeS += (int)s.charAt(i);
        for(int i=0;i<t.length(); i++) codeT += (int)t.charAt(i);
        
        return (char)(codeT-codeS);

        
    }
}