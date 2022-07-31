class Solution {
    public int maximumGroups(int[] grades) {
        
        if(grades.length ==1 || grades.length==2) return 1;

        int groups=0;
        PriorityQueue<Integer> tempQ=new PriorityQueue<>();

        int maxSum=0;

        Arrays.sort(grades);

        for(int x:grades){
            tempQ.add(x);
        }


        //intial work
        int prevSize=1;
        maxSum=tempQ.poll();
        groups++;



        while(!tempQ.isEmpty()){

            int currSum=0;
            //int currSize=0;
            int j=0;

            //System.out.println("maxSum " + maxSum + " prevSize " + prevSize);

            if(tempQ.size()<=prevSize) break;
            //System.out.println(tempQ);
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