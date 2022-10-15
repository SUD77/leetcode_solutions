class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      
        int[] res=new int[nums1.length];
        int k=0;
        
        for(int i=0;i<nums1.length;i++){
            
            int currGre=-1;
            
            int j=0;
            
            while(nums2[j]!=nums1[i]){
                
                j++;
            }
            
            while(j<=nums2.length-1){
                
                if(nums2[j]>nums1[i]){
                    currGre=nums2[j];
                    break;
                }
                j++;
            }
            
            res[k++]=currGre;
        }
        
        return res;
    }
}