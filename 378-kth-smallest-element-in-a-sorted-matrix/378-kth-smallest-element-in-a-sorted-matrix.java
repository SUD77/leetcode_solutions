class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int result=0;

        for(int[] x:matrix){
            for(int y:x){
                pq.add(y);
            }
        }


        while(k>0){
            
            result=pq.poll();
            k--;
        }
        
        return result;
        
    }
}