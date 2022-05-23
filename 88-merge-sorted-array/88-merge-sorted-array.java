class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        /* size2 is the length of nums2
           size1 is the length of nums1.
           (PS : I didnt look at the fucntion variables, should have simply used m and n.)
        */
        int size2=nums2.length;
        int size1=nums1.length-size2;

        /* i iterates over length m
        j iterates over length n
        k iterates over whole length of nums1 and stores the sorted array.
        */
        int i=size1-1;
        int j=size2-1;
        int k=nums1.length-1;

       
        /* Logic : Iteration is being done from back of both arrays, and simulataneously storing the ans
        to the back of nums1. (This is the last else part of this if-else).
        */
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

            /*Checks for all the left items in nums1 that haven't been iterated by i. That is, i is not
            equalt to -1. */
            while(i>=0){
                nums1[k]=nums1[i];
                i--;
                k--;
            }
            
            /*Checks for all the left items in nums2 that haven't been iterated by j. That is, j is not
            equalt to -1. */
            while(j>=0){
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }   
        
        
    }
}