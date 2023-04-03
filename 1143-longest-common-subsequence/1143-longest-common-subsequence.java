//Sapce Optimization
// TC - O(len1 * len2)
// SC - O(len2)

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int len1=text1.length();
        int len2=text2.length();
        
        int[] prev=new int[len2+1];
        
        
        for(int i=0;i<=len2;i++){
            prev[i]=0;
        }
        
        prev[len2]=0;
        
        for(int i=len1-1;i>=0;i--){
            
            int[] curr=new int[len2+1];
            
            for(int j=len2-1;j>=0;j--){
                
                if(text1.charAt(i)==text2.charAt(j)){
                    curr[j]=1+prev[j+1]; 
                }else{
                    curr[j]= Math.max(prev[j],curr[j+1]); 
                }

                
            }
            prev=curr;
        }
        
        
        return prev[0]; 
    }

}