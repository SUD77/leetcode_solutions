class Solution {
    public boolean isMatch(String s, String p) {
        
        int len1=s.length();
        int len2=p.length();
        
        int[][] dp=new int[len1][len2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(s,p,len1-1,len2-1,dp)==1;
    }
    
    public int solUtil(String s,String p,int index1,int index2,int[][] dp){
        
        //when p is exhausted
        if(index1<0 && index2<0) return 1;
        if(index1>=0 && index2<0) return 0;
        
       
        
        //when s is exhausted but p has not, so if p has all stars, true. 
        if(index1<0 && index2>=0){
            
            for(int i=0;i<=index2;i++){
                if(p.charAt(i)!='*') return 0;
            }
            return 1;
        }
        
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        
        if(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='?'){
            return dp[index1][index2]= solUtil(s,p,index1-1,index2-1,dp);
        }
        
        if(p.charAt(index2)=='*'){
            
            // fist case is if i take * as empty
            //second case we match it to letters of s.
            
            int takeStarEmpty= solUtil(s,p,index1,index2-1,dp);
            int takeStarNotEmpty=solUtil(s,p,index1-1,index2,dp);  
            
            if(takeStarEmpty==0 && takeStarNotEmpty==0){
                return dp[index1][index2]=0;
            }else{
                 return dp[index1][index2]=1; 
            }
            
        }
        
        return dp[index1][index2]=0;
    }
}