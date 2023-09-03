class Solution {
    public int uniquePaths(int m, int n) {
        
        int[] prev=new int[n];
        
        for(int i=m-1;i>=0;i--){
            
            int[] cur=new int[n];
            
            for(int j=n-1;j>=0;j--){
                
                if(i==m-1 && j==n-1) cur[j]=1;
                else{
                    int down=0;
                    int right=0;
                    
                    if(i+1<m) down=prev[j];
                    if(j+1<n) right=cur[j+1];
                    
                    cur[j]=down+right;
                }
                
                
            }
            
            prev=cur;
        }
        
        return prev[0];
    }
    
    
}