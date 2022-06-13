class Solution {
    public int longestConsecutive(int[] nums) {
        
        // if(nums.length==1){
        //     return 1;
        // }
        
        int maxLength=0;
        int currLength=0;

        HashSet<Integer> temp=new HashSet<>();

        for(int x:nums){
            temp.add(x);
        }

        for(int x:nums){

            boolean check=true;
            currLength=0;
            int j=x;
            if(temp.contains(x-1)){}
            else{
                while(temp.contains(j)){
                    currLength++;
                    j++;
                }
            }
            maxLength=Math.max(currLength,maxLength);
        }


        return maxLength;

    }
}