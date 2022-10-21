class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        
        //SLIDING WINDOW 
        
        Set<Integer> set= new HashSet<Integer>();        
        
        for (int i=0; i<nums.length; i++){
            
            if (!set.add(nums[i])) return true; 
            // if duplicate is in k sized window and cant be readded then return true
            
            
            if (set.size()>k) set.remove(nums[i-k]); 
            /*if the size of window has risen above k, we need to trim the initial elements of window since 
			their duplicate doesn't lie in the window of range k anymore, and we will look for duplicates within the current window.... */
            
            /* 
            for example --->
            in 1,2,3,1 k=2, set is [1,2] till second element.. 
            on third element set=[2,3]
            on fourth element set=[3,1]
            set doesn't hold 1 now so it can be said that 1 has duplicate but not within k next elements, so false
            */
            
        }
        
        return false;
    }
}