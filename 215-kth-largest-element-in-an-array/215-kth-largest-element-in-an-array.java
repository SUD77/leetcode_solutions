class Solution {
    public int findKthLargest(int[] nums, int k) {
       
      if(nums==null || nums.length==0) return Integer.MAX_VALUE;
        return solUtil(nums,0,nums.length-1,nums.length-k);
        
    }
    
    
    // quick select: kth smallest
    public int solUtil(int[] nums,int start ,int end,int k){
        
        if(start>end) return Integer.MAX_VALUE;
        
        int pivot=nums[end]; //Taking A[end] as the pivot
        int left=start;
        
        for(int i=start;i<end;i++){
            if(nums[i]<=pivot) //put no < pivot to pivot's left
                swap(nums,left++,i);
        }
        swap(nums,left,end); //Finally, swap A[end] with A[left]
        
        
        if(left==k) //ans is here
            return nums[left];
        else if (left < k) // check right part
            return solUtil(nums,left+1,end,k);
        else //check left part
            return solUtil(nums,start,left-1,k);
        
        
        
    }
    
    
    void swap(int[] A,int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}