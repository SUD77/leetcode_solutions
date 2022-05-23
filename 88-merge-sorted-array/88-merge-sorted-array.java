class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
         int size2=nums2.length;
        int size1=nums1.length-size2;

        int i=size1-1;
        int j=size2-1;
        int k=nums1.length-1;

        //int[] result=new int[size1+size2];
        if(n==0){
            
        }
        else if(m==0){
            for(int tempi=0;tempi<n;tempi++){
                nums1[tempi]=nums2[tempi];
            }
        }else{
            while(i>=0 && j>=0){

                if(nums1[i]<=nums2[j]){
                    nums1[k]=nums2[j];
                    j--;
                }else{
                    nums1[k]=nums1[i];
                    i--;
                }
                k--;
            }

            while(i>=0){
                nums1[k]=nums1[i];
                i--;
                k--;
            }
            
            while(j>=0){
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }   
        
        
    }
}