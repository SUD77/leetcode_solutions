// https://leetcode.com/problems/sum-of-matrix-after-queries/discuss/3594967/Explained-O(N)-oror-Very-simple-and-easy-to-understand-solution
class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> cols=new HashSet<>();
        
        int rowCount=n;
        int colCount=n;
        long sum=0;
        
        for(int i=queries.length -1; i>=0 ; i--){
            
            int type=queries[i][0];
            int index=queries[i][1];
            int val=queries[i][2];
            
            if(type==0){
                
                if(rows.contains(index)) continue;
                
                rows.add(index);
                rowCount--;
                sum+=colCount * val;
            }else{
                
                if(cols.contains(index)) continue;
                cols.add(index);
                colCount--;
                sum+=rowCount*val;
            }
        }
        
        return sum;
        
    }
}