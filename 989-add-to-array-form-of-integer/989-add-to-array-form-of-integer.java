class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
       
        int size=nums.length;

        List<Integer> temp=new ArrayList<>();

        for(int i=size-1;i>=0;i--){
            temp.add(0,(nums[i]+k)%10);
            k=(nums[i]+k)/10;
        }
        
        while(k>0){
            temp.add(0,k%10);
            k=k/10;
        }
        
        return temp;
     
        
    }
}