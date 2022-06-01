class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
         int size1= nums1.length;;
        int size2=nums2.length;

        int i=0;
        int j=0;
        int k=0;
        int targetIndice=0;
        double ans=0.0;
        
        int[] result=new int[size1+size2];

        while(i<size1 && j<size2){

            if(nums1[i]<=nums2[j]){
                result[k++]=nums1[i];
                i++;
            }else{
                result[k++]=nums2[j];
                j++;
            }
        }

        while(i<size1){
            result[k++]=nums1[i];
            i++;
        }

        while(j<size2){
            result[k++]=nums2[j];
            j++;
        }

        int size3= result.length;
        
        
        if(size3%2 !=0) {
            targetIndice = ((size1 + size2) - 1) / 2;
            ans=(double)result[targetIndice];
        }else{
            targetIndice=size3/2;
            ans=(double)(result[targetIndice]+result[targetIndice-1])/2;
        }


        return ans;
    }
}