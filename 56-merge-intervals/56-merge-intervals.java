class Solution {
    public int[][] merge(int[][] intervals) {
       
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});

        List<int[]> temp=new ArrayList<>();

        int start=intervals[0][0];
        int end=intervals[0][1];

        int i=0;

        while(i<intervals.length){

            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{
                int[] arr=new int[2];
                arr[0]=start;
                arr[1]=end;
                start=intervals[i][0];
                end=intervals[i][1];
                temp.add(arr);
            }
            i++;
            
            //Special condition for when interval is of 1 length or
            //element is the last one of the interval 
            if(i==intervals.length){
                int[] arr=new int[2];
                arr[0]=start;
                arr[1]=end;
                temp.add(arr);
            }

        }

        int[][] result=new int[temp.size()][2];
        int j=0;

        for(int[] x:temp){
           
            result[j][0]=x[0];
            result[j][1]=x[1];
            j++;
        }
        
        return result;

        
    }
}