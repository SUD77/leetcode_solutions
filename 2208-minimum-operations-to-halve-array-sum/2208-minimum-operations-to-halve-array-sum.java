class Solution {
    public int halveArray(int[] nums) {
        
        
       int ans=0;

        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());

        double sum=0;

        for(int x:nums){
            sum+=x;
            pq.add((double) x);
        }

//        System.out.println(pq);
//
//        System.out.println(sum);

        double mainSum=sum;
        while (sum>mainSum/2){

            double temp=pq.poll();

            sum-=temp;
            temp=temp/2;

            sum+=temp;
            pq.add(temp);
            ans++;

        }

        return ans;
    }
}