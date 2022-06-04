class Solution {
    public int maximumTop(int[] nums, int k) {
        //To keep the max element
        int maxEle=nums[0];
        
        
        //Case : k=0
        if(k==0) return nums[0];
        
        //Case : when nums contains 1 ele and k is odd.
        if(nums.length==1 && k%2!=0) return -1;
        
        // Case : when k == nums.length
        if(nums.length==k){
            for(int i=0;i<nums.length-1;i++) {
                maxEle=Math.max(maxEle,nums[i]);
            }
            return maxEle;
        }
        
        //Case : k==1
        if(k==1) return nums[1];
        
        
        // i is counter to move on nums.
        int i=0;
        boolean check=false;

        
        while(check!=true){

            //Case when k> nums.length
            if(k > nums.length){

                Arrays.sort(nums);
                maxEle=nums[nums.length-1];
                return maxEle;
            }
            
            //Case : all left cases. 
            if(i < nums.length && k>1){

                maxEle=Math.max(maxEle,nums[i]);
                i++;
                k--;
            }else if(i< nums.length && k==1){
                if(nums[i+1]>maxEle) {
                    maxEle=nums[i+1];
                    return maxEle;
                }
                else return maxEle;
            }

        }
        
        return maxEle;
    }
}