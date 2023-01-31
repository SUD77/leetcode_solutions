class Solution {
    public int bestTeamScore(int[] s, int[] ag) {
        
         int n=s.length;
        pair a[]=new pair[n];
        for(int i=0;i<n;i++)a[i]=new pair(s[i],ag[i]);
        // sort based on the age
        Arrays.sort(a,(x,y)->x.age==y.age?x.sco-y.sco:x.age-y.age);
        int dp[]=new int [n];
        dp[0]=a[0].sco;int ans=a[0].sco;
        // you just have to find the maximum inc subseqence 
        for(int i=1;i<n;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                if(a[j].sco<=a[i].sco){
                    sum=Math.max(sum,dp[j]);
                }
            }
            dp[i]=a[i].sco+sum;
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
    
    class pair{
    int sco,age;
    pair(int sco,int age){
        this.sco=sco;
        this.age=age;
    }
}
}