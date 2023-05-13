class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        
    long[] lengthOfStrings=new long[200005];

       long mod=1000000007;

       long ans=0;

       lengthOfStrings[0]=1;

      
       for(int i=0;i<100005;i++){

           lengthOfStrings[i+zero]=lengthOfStrings[i+zero]%mod;

           lengthOfStrings[i+zero]=lengthOfStrings[i+zero]+lengthOfStrings[i];

           lengthOfStrings[i+one]=lengthOfStrings[i+one]%mod;

           lengthOfStrings[i+one]=lengthOfStrings[i+one]+lengthOfStrings[i];
          

       }

       for(int j=low;j<=high;j++){
           ans=(ans+lengthOfStrings[j])%mod;
       }

       return (int)ans;
    }
}