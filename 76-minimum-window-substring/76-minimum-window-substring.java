class Solution {
    public String minWindow(String s, String t) {
        
        int[] tempArr=new int[128];
        
        for(char c:t.toCharArray()){
            tempArr[c]++;
        }
        
        int start=0, end=0, minStart=0, minLen=Integer.MAX_VALUE, counter=t.length();
        
        while(end < s.length()){
            
            final char c1=s.charAt(end);
            
            if(tempArr[c1]>0) counter--;
            tempArr[c1]--;
            end++;
            
            while(counter==0){
                
                if(minLen>end-start){
                   minLen=end-start;
                    minStart=start;
                }
                
                final char c2=s.charAt(start);
                
                tempArr[c2]++;
                
                if(tempArr[c2]>0) counter++;
                start++;
            }
        }
        
        return minLen==Integer.MAX_VALUE ? "":s.substring(minStart,minStart+minLen);
    }
}