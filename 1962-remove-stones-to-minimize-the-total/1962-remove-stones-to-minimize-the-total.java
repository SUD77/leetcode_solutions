class Solution {
    public int minStoneSum(int[] piles, int k) {
        
         int ans=0;

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int x:piles){
            pq.add(x);
        }

        while (k>0){

            int temp=pq.poll();
            temp= (int) Math.ceil((double) temp/2.0);

            pq.add(temp);
            k--;
        }

        while (!pq.isEmpty()){
            ans+=pq.poll();
        }

        //System.out.println(pq);

        return ans;
    }
}