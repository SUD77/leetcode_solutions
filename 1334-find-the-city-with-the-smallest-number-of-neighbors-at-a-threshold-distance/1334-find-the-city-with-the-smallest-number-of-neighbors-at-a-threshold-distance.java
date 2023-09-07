class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] mat=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                mat[i][j]=(int)1e8;
                
                if(i==j) mat[i][j]=0;
            }
        }
        
        
        for(int i=0;i<edges.length;i++){
            
            int startCity=edges[i][0];
            int endCity=edges[i][1];
            int distance=edges[i][2];
            
            mat[startCity][endCity] = distance;
            mat[endCity][startCity] = distance;
            
        }
        
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }
        
        
        // for(int[] x:mat){
        //     System.out.println(Arrays.toString(x));
        // }
        
        int noOfCity=Integer.MAX_VALUE;
        int ans=0;
        
        for(int i=0;i<n;i++){
            
            int count=0;
            
            for(int j=0;j<n;j++){
                
               if(mat[i][j]<=distanceThreshold) {
                    count++;
                }
            
            }
            
            if(count<=noOfCity){
                noOfCity=count;
                ans=i;
            }
        }
        
        return ans;
        
        
        
        
    }
}