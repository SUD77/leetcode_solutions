class Solution {
    public int countEven(int num) {
    
        int count=0;
        
        for(int i=1;i<=num;i++){
            
            if(i<10 && i%2==0) count++;
            else if(i>=11){
                if(check(i)) count++;
            }
        }
        
        return count;
    }
    
    
    public boolean check(int num){
        int sum=0;
        
        while(num>0){
        
            sum+=num%10;
            num=num/10;
        }
        
        if(sum%2==0) return true;
        
        return false;
    }
}