class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int ans=0;

        int[][] temp=new int[capacity.length][3];

        for(int i=0;i<capacity.length;i++){
            temp[i][0]=capacity[i];
            temp[i][1]=rocks[i];
        }

         Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                int a=o1[0]-o1[1];
                int b=o2[0]-o2[1];
                 if (a - b > 0) return 1;
                else if(a-b < 0) return -1;
                else return 0;

            }
        });


        // for(int[] x:temp){
        //     System.out.println(Arrays.toString(x));
        // }

        int j=0;
        while (additionalRocks>0 && j<capacity.length){

            int tempVar=temp[j][0]-temp[j][1];
            if(tempVar==0) {
                ans++;
            }else{
                int toFill=temp[j][0]-temp[j][1];

                if(additionalRocks>=toFill) {
                    additionalRocks-=toFill;
                    temp[j][1]+=toFill;
                    ans++;
                }else {
                    break;
                }
            }
            j++;
        }


        return ans;
    }
}