//https://www.youtube.com/watch?v=-ub_B9njGn8&t=1118s

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] charMapOfS1=new int[26];
        
        for(char c: s1.toCharArray()) charMapOfS1[c-'a']++;
        
        int j=0,i=0;
        
        int countChars=s1.length();
        
        while(j<s2.length()){
            
            if(charMapOfS1[s2.charAt(j++)-'a']-- > 0)
                countChars--;
            
            if(countChars==0) return true;
            
            /*
            Below if condition is for case like, 
            when s1=ab
            s2=boa, bboa, bba
            
            here when we will encouter first b, we will derement count of b, but later wont find the
            correspoding a.
             */
            // j-i == s1.length() -> This is the window
            if(j-i == s1.length() && charMapOfS1[s2.charAt(i++)-'a']++ >=0 )
                countChars++;
        }
        
        return false;
        
    }
}