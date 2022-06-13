/*Not my code and logic*/


class Solution {
    
    private Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        
        
        int n=triangle.size();
        memo=new Integer[n][n];
        return solUtil(0,0,triangle);
        
    }
    
    public int solUtil(int i,int j,List<List<Integer>> triangle){
        
        
        if(memo[i][j]!=null) return memo[i][j];
        
        int path=triangle.get(i).get(j);
        if(i<triangle.size()-1){
            path+=Math.min(solUtil(i+1,j,triangle),solUtil(i+1,j+1,triangle));
        }

        return memo[i][j]=path;
        
        
    }
}