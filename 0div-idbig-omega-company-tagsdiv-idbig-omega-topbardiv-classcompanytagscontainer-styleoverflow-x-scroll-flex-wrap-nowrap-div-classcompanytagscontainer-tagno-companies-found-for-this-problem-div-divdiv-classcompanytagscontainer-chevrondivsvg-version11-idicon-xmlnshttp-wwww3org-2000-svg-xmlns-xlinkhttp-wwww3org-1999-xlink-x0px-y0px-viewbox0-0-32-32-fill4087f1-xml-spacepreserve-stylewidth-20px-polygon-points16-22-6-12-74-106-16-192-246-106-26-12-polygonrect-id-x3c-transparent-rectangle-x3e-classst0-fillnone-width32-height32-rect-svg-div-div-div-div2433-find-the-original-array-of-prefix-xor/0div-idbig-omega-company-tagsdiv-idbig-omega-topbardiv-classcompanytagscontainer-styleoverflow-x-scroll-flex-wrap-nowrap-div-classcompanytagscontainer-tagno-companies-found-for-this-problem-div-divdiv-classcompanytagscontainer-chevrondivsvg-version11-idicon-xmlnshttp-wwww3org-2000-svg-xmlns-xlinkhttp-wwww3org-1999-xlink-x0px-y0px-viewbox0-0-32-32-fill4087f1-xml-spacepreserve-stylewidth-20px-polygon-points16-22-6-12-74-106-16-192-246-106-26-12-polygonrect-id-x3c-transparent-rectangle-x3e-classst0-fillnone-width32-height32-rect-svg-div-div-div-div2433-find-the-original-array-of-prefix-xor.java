class Solution {
    public int[] findArray(int[] pref) {
       
          int[] res=new int[pref.length];
         int k=0;

         res[k++]=pref[0];
         int xr=res[0];

         for(int i=1;i< pref.length;i++){
             if(i>1) xr^=res[i-1];
             res[k++]=xr^ pref[i];

         }

         return res;
    }
}