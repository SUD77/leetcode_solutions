class Solution {
    public int thirdMax(int[] nums) {
      
        
        int res=0;

        Set<Integer> st=new TreeSet<>();
        for (int x:nums){
            st.add(x);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        Iterator<Integer> it=st.iterator();

        while (it.hasNext()){
            pq.add(it.next());
        }


        if(pq.size()<3) return pq.poll();

        int i=0;
        while(i<2){
            pq.poll();
            i++;
        }

        res=pq.poll();



        return res;
    }
}