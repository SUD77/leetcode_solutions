//https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/discuss/4117230/JAVA-oror-O(N)-Time-O(1)-Space-oror-Faster-oror-Easiest-Approach-oror-Easy-To-Understand

class Solution {
     public boolean winnerOfGame(String colors) {
        int aCnt=0, bCnt=0;
        int aTemp=0, bTemp=0;

        for(int i=0;i<colors.length();i++)
        {
            char c = colors.charAt(i);
            if(c=='A')
            {
                bTemp=0;
                aTemp+=1;
                if(aTemp>=3)
                {
                    aCnt+=1;
                }
            }
            else
            {
                aTemp=0;
                bTemp+=1;
                if(bTemp>=3)
                {
                    bCnt+=1;
                }
            }
        }
        return aCnt>bCnt;
    }
}