class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans=new HashSet<>();
        
        Arrays.sort(nums);
        
        int n=nums.length;
        
         /*If we have target sum as negative but all numbers in the array are positive, then simple return an empty collection*/
        if(nums[0]>0 && target<0) return new ArrayList<>(ans);
        
        /*If we have target sum as positive and all numbers in the array are negative then simple return an empty list, as we will never get positive number out of sum of negative integer. other than integer overflow.
        */
        if(nums[nums.length-1]<0 && target>0) return new ArrayList<>(ans);
        
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                
                
                
                int firstTwoSum=nums[i] + nums[j];
                
                int left=j+1;
                int right=n-1;
                
                while(left<right){
                  
                    int lastTwoSum=nums[left] + nums[right];
                    List<Integer> tempAns=new ArrayList<>();
                    
                    int finalSum= firstTwoSum+lastTwoSum;
                    
                    if(finalSum == target){
                        tempAns.add(nums[i]);
                        tempAns.add(nums[j]);
                        tempAns.add(nums[left]);
                        tempAns.add(nums[right]);
                        ans.add(tempAns);
                        left++;
                        right--;
                    }else if(finalSum < target) left++;
                    else right--;
                }
            }
        }
        
        
        return new ArrayList<>(ans);
    }
}