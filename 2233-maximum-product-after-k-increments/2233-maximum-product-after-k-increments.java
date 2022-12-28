class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        
        long ans=1;
        int mod=1000000007;

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int x:nums){
            pq.add(x);
        }

        while (k>0){
            int temp=pq.poll();
            temp+=1;

            pq.add(temp);
            k--;
        }

        while (!pq.isEmpty()){
            ans=(ans*pq.poll())%mod;
        }

        return (int)ans;
    }
}