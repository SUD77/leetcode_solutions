//Tc - O(n) + O(n)
// Sc - O(n)

class Solution {
    public int findDuplicate(int[] nums) {
        
        int[] temp=new int[nums.length];
        
        for(int i=0;i<temp.length;i++){
            temp[nums[i]]++;
        }
        
        for(int i=0;i<temp.length;i++){
            if(temp[i]>=2) return i;
        }
        
        return 0;
    }
}