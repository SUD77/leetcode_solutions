class Solution {
    public int[] decode(int[] encoded, int first) {
      
        int[] result=new int[encoded.length+1];
        int k=0;
        result[k]=first;
        for(int i=0;i< encoded.length;i++){
            int ans=encoded[i]^result[k];
            result[++k]=ans;
        }

        
        return result;
    }
}