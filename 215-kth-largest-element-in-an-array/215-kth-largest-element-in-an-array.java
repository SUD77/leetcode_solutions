class Solution {
    public int findKthLargest(int[] nums, int k) {
       
      PriorityQueue<Integer> temp=new PriorityQueue<>();

        for(int x:nums){
            temp.add(x);
            if(temp.size()>k){
                temp.poll();
            }
        }
        
        return temp.poll();
        
    }
}