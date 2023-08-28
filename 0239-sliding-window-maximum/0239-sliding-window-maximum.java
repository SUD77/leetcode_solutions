class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n=nums.length;
        
        int ans[]= new int[n-k+1];
        
        Deque<Integer> q=new LinkedList<>();
        
        int i=0;
        int j=0;
        
        while(j<n){
            
            // calculation
            if(q.size()==0){
                q.add(nums[j]);
            }else{
                
                // All element before j which are less than it, are useless. 
                while(q.size()>0 && q.peekLast()<nums[j]){
                    q.removeLast();
                }
                q.add(nums[j]);
            }
            
            // move j 
            
            if(j-i+1 < k) j++;
            else if(j-i+1==k){   // if we hit the window size
                
                // answer -> calculation
                //Storing the max in the window
                ans[i]=q.peek();
                
                //slide the window
                //calculation
                
                //Before moving the i, removing the ele on i
                if(nums[i]==q.peek()){
                    q.removeFirst();
                }
                
                //now slide the pointer
                i++;
                j++;
            }
            
        }
        
        return ans;
        
    }
}