class Solution {
    public int xorOperation(int n, int start) {
        int[] nums=new int[n];
        int i=0;
        for(i=0;i<n;i++){
            nums[i] = start + 2 * i;
        }
        
        int x=0;
        
        for(int j=0;j<n;j++){
            x = x ^ nums[j];
        }
        
        return x;
    }
}