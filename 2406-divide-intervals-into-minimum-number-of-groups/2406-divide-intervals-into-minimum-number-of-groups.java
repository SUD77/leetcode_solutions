class Solution {
    public int minGroups(int[][] intervals) {
        
        int[] leftIntervals=new int[intervals.length];
        int[] rightIntervals=new int[intervals.length];
        
        for(int i=0;i<intervals.length;++i){
            leftIntervals[i]=intervals[i][0];
            rightIntervals[i]=intervals[i][1];
        }
        
        Arrays.sort(leftIntervals);
        Arrays.sort(rightIntervals);
        
        int result=0;
        int cur=0;
        
        int leftItr=0,rightItr=0;
        
        while(leftItr < leftIntervals.length){
            
            if(leftIntervals[leftItr] <= rightIntervals[rightItr]){
                
                cur++;
                result=Math.max(result,cur);
                leftItr++;
                continue;
            }else if(leftIntervals[leftItr] > rightIntervals[rightItr]){
                
                cur--;
                rightItr++;
                continue;
            }
        }
        
        return result;
    }
}