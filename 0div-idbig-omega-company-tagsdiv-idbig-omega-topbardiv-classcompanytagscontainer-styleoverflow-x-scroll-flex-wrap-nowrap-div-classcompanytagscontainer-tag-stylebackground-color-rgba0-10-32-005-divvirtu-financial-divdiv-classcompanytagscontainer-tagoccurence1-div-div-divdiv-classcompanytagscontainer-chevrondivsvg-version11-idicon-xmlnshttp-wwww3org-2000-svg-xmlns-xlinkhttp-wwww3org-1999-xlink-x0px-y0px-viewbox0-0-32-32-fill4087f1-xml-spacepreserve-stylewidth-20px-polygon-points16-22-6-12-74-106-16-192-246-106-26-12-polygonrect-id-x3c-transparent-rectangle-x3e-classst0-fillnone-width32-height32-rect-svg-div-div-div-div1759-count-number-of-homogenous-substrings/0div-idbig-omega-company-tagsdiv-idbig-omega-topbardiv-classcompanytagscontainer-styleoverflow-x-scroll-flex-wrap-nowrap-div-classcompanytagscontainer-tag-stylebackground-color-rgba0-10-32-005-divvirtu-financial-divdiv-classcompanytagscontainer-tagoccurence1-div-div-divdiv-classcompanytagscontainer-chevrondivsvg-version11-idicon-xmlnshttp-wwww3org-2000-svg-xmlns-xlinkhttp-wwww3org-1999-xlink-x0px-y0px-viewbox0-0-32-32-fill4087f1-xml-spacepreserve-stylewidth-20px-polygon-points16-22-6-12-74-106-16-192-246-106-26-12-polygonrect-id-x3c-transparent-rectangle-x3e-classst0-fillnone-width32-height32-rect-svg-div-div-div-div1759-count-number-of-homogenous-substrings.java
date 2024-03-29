//https://leetcode.com/problems/count-number-of-homogenous-substrings/discuss/4266865/Simple-Java-Solution-O(N)

class Solution {
    int mod=1000000007;
    public int countHomogenous(String s) {
        long cnt=1;
        long ans=0;
        for(int i=0;i<s.length() - 1;i++)
        {
            if(s.charAt(i)!=s.charAt(i+1))
            {
                long temp=(((cnt%mod)*((cnt+1)%mod))%mod)/2;
                ans=(ans+temp)%mod;
                // System.out.println(ans);
                cnt=1;
            }
            else{
                cnt++;
                cnt%=mod;
            }
        }

        long temp=(((cnt%mod)*((cnt+1)%mod))%mod)/2;
        ans=(ans+temp)%mod;
        // System.out.println(ans);
        cnt=1;


        return (int)ans%mod;
    }
}