class Solution {
    public int longestPalindromeSubseq(String s) {
        
        
        //Start  : Creating reverse of s
        StringBuffer tempS=new StringBuffer(s);
        tempS.reverse();
        String s2=tempS.toString();
        //End 
        
        int len1=s.length();
        int len2=s2.length();
        
        
        int[] prev=new int[len2+1];
        
        int[] curr=new int[len2+1];
       
        
        for(int i=1;i<=len1;i++){
            
            for(int j=1;j<=len2;j++){
                
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
        
            }
            prev=(int[]) (curr.clone());
        }
               
        return prev[len2];

    }
    
}