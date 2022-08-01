class Solution {
    //Using Combinations | TC= O(Math.min(row-1, col-1)) | SC = O(1)
    
    public int uniquePaths(int m, int n) {
        
        int N = m + n - 2;  //Total no of moves        
        int r = Math.min(m , n) - 1; //take combination of either row-1 or col-1
        
        double res = 1;
        for(int i=1; i<= r ; i++){
         //   res = res * (N-r + i )/ i;
            res = res * (N-i+1) / i; // ---->  my logic
        }
        
        return (int)res;
    }
}