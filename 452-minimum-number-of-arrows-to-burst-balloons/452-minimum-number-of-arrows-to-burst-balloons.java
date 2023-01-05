/*
[[-2147483646,-2147483645],[2147483646,2147483647]]

it will fail because you sort the points as lambda function.
at the comparison of -2147483645 and 2147483647 -> b[1] - a[1] = 2147483647 - (-2147483645) = 2147483647 + 2147483645) = OVERFLOW.

*/


class Solution {
    public int findMinArrowShots(int[][] points) {
        
        if(points.length==0){
            return 0;
        }
        
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] > b[1]) return 1;
                else if(a[1] < b[1]) return -1;
                else return 0;
            }
        });
        
        int arrowPos = points[0][1];
        int arrowCnt=1;
        
        for(int i=1;i<points.length;i++){
            
            if(arrowPos >= points[i][0]){
                continue;
            }
            
            arrowCnt++;
            arrowPos=points[i][1];
        }
        
        return arrowCnt;
    }
}