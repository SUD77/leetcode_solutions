class Solution {
    public int maximumGroups(int[] grades) {
        
        if(grades.length ==1 || grades.length==2) return 1;

        int groups=0;
        PriorityQueue<Integer> tempQ=new PriorityQueue<>();

        int maxSum=0;

        //Arrays.sort(grades);

        //Intially adding the data in pq
        for(int x:grades){
            tempQ.add(x);
        }


        //Creating the first group. 
        int prevSize=1;
        maxSum=tempQ.poll();
        groups++;



        while(!tempQ.isEmpty()){

            int currSum=0;
            
            int j=0;

          

            if(tempQ.size()<=prevSize) break;
        
            while(j <= prevSize){


                currSum+=tempQ.peek();
                tempQ.remove();

                j++;

                if(tempQ.isEmpty()) {
                    break;
                }
            }

            maxSum=Math.max(currSum,maxSum);
            prevSize=Math.max(j,prevSize);
            groups++;


        }


        return groups;
    }
}