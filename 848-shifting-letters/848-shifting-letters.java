class Solution {
    public String shiftingLetters(String s, int[] shifts) {
       
        int sum=0;
        int n=shifts.length;
        int len=s.length();
        
        // for(int i=n-1;i>=0;i--){
        //     sum+=shifts[i];
        //     shifts[i]=sum;
        // }
        
        
        // System.out.println(Arrays.toString(shifts));
        char[] result=s.toCharArray();
        
        int tempSum=0;
        
        for(int i=len-1;i>=0;i--){
            
            tempSum= (tempSum+ shifts[i])%26;
            int k=tempSum%26;
            int p=(result[i]-'a'+ k+ 26)%26;
            
            result[i]=(char)('a' + p);
            
        }
        
        return new String(result);
    }
}