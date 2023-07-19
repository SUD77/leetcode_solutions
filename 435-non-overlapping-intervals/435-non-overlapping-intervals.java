class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals , (x,y) -> (x[0] == y[0]) ? x[1] - y[1] : x[0] - y[0] );
        
        for(int[] arr : intervals){
            System.out.println(Arrays.toString(arr));
        }
        
        
        int count=0;
        
        int start = intervals[0][0];
        int end = intervals[0][1];
      
        for(int i=1; i<n; i++){
           if(intervals[i][0] < end){
               count++;
               end = Math.min(end , intervals[i][1]);
           }
            else{
                //start = intervals[i][0]; //not required bcz we are not using start value for comparison.
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}


