class Solution {
    public void sortColors(int[] nums) {
        
        int[] countArray=new int[3];
        int itr=0;
        
        for(int x:nums){
            countArray[x]++;
        }
        
        //System.out.println(Arrays.toString(countArray));
        
        for(int i=0;i<3;i++){
            
            for(int j=0;j<countArray[i];j++){
                nums[itr++]=i;
            }
        }
    }
}