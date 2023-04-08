class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1=word1.length();
        int len2=word2.length();
        
        int[] prev=new int[len2+1];
        
        
        for(int i=0;i<=len2;i++){
            prev[i]=i;
        }
        
        prev[0]=0;
        
        for(int i=1;i<=len1;i++){
            int[] curr=new int[len2+1];
            curr[0]=i;
            
            for(int j=1;j<=len2;j++){
                
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }else{

                    int insert=1+curr[j-1]; 
                    int delete=1+prev[j]; 
                    int replace=1+prev[j-1]; 

                    curr[j]=Math.min(insert,Math.min(delete,replace));
                }
            }
            
            prev = curr;
        }
        
        return prev[len2];
    }
    
}