// using binary search 

class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);
        
        int len=1;
        
        for(int i=1;i<n;i++){
            
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
                len++;
            }else{
                int index=binarySearch(ans,nums[i]);
                ans.set(index,nums[i]);
            }
        }
        
        return len;
              
    }
    
    public int binarySearch(ArrayList<Integer> ans,int key){
        
        int low=0;
        int high=ans.size()-1;
        
        while(low<=high){
            
            int mid=low+ (high-low)/2;
            
            if(ans.get(mid)==key) return mid;
            else if(ans.get(mid)<key){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return high+1;
    }
}