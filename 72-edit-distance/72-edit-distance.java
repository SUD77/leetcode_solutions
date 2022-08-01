class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1=word1.length();
        int len2=word2.length();
        
        
        int[] prev=new int[len2+1];
        int[] curr=new int[len2+1];
        
        
        for(int j=0;j<=len2;j++){
            prev[j]=j;
        }
        
        
        for(int i=1;i<=len1;i++){
            
            curr[0]=i;
                
            for(int j=1;j<=len2;j++){
                
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }
                
                else curr[j]=1+Math.min(prev[j-1],Math.min(prev[j],curr[j-1]));
            }
            prev = (int[])(curr.clone());
                
        }
        
        return prev[len2];
    }
    
}