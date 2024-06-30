//Space Optimization  
//TC - O(m*n)
//SC - O(n)

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[] prev=new int[n+1];
        Arrays.fill(prev,1);
        
        
        for(int i=1;i<m;i++){
            int[] curr=new int[n+1];
            curr[0]=1;
            for(int j=1;j<n;j++){
             
                curr[j]=curr[j-1] + prev[j];
            }
            
            prev=curr;
        }
        
        return prev[n-1];
    }
    
}