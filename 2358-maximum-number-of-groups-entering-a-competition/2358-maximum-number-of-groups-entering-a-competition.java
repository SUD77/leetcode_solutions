class Solution {
    public int maximumGroups(int[] grades) {
        
        if(grades.length ==1 || grades.length==2) return 1;

        int groups=0;
        PriorityQueue<Integer> tempQ=new PriorityQueue<>();

        int maxSum=0;

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

          
            //If remaining elements are not greater than coun of prevsize, we 
            // will end the case.
            if(tempQ.size()<=prevSize) break;
        
            //Taking care that next group is larger than previous
            while(j <= prevSize){


                currSum+=tempQ.peek();
                tempQ.remove();

                j++;
                
                //IF PQ gets empty we go out of the loop.
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