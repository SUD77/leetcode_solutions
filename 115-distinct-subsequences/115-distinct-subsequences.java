class Solution {
    public int numDistinct(String s, String t) {
        
        int len1=s.length();
        int len2=t.length();
        
        int[] prev=new int[len2+1];
        
        for(int i=0;i<=len2;i++){
            prev[i]=0;
        }
        
        prev[0]=1;
        System.out.println(Arrays.toString(prev));
        
        for(int i=1;i<=len1;i++){
            
            int[] curr=new int[len2+1];
            curr[0]=1;
            
            for(int j=1;j<=len2;j++){
                
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]= prev[j-1] + prev[j]; 
                }else{
                    curr[j]=prev[j];
                }

            }
            
            prev=curr;
            System.out.println(Arrays.toString(prev));
        }
        
        
        return prev[len2]; 
    }
        
}



/*

[1, 0, 0, 0]
[1, 1, 0, 0]
[1, 1, 1, 0]
[1, 2, 1, 0]
[1, 2, 1, 1]
[1, 3, 1, 1]
[1, 3, 4, 1]
[1, 3, 4, 5]



*/