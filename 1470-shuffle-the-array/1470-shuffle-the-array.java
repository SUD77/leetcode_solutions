import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        ArrayList<Integer> arr1=new ArrayList<Integer>();
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        int [] arr=new int[(2*n)];
        for(int i=0;i<n;i++){
            arr1.add(nums[i]);
        }
        
        for(int i=n;i<2*n;i++){
            arr2.add(nums[i]);
        }
        
        for(int i=0;i<n;i++){
            result.add(arr1.get(i));
            result.add(arr2.get(i));
        }
        
        // for(Integer x:result){
        //     System.out.println(x);
        // }
        
        for(int i=0;i<2*n;i++){
            arr[i]=result.get(i);
        }
       
        return arr;
        
    }
}