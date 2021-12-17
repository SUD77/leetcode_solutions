import java.util.Arrays;  

class Solution {
    public int[] decompressRLElist(int[] nums) {
        
//         HashMap<Integer,Integer> temp=new HashMap<Integer,Integer>();
//         int count=0;
        
//         for(int i=0;i<nums.length;i=i+2){
//             temp.put(nums[i],nums[i+1]);
//             count= count+nums[i];
//         }
        
//         int[] result=new int[count];
//         int k=0;
        
//         //System.out.println(temp);
        
//         for(Integer x:temp.keySet()){
//             for(int j=0;j<x;j++){
//                 result[k++]=temp.get(x);
//             }
//         }
        
//         //Arrays.sort(result);
//         return result;
        
        int arrSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }
        
        int[] result = new int[arrSize];

        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
        
    }
}