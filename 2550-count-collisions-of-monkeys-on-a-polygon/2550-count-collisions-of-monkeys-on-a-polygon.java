class Solution {
    public int monkeyMove(int n) {
        
        long base=2;
        int power =n;
        
        long res=1;
        
        long mod=(long) 1e9+7;
        
        while(power>0){
            
            if(power%2==1){
                res=(res*base)%mod;
                power=power-1;
            }else{
                base=(base*base)%mod;
                power>>=1;
            }
        }
        
        return (int)((res-2+mod)%mod);
        
    }
}