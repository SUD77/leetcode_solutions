class Solution {
    public boolean isPowerOfFour(int n) {
        
        return solUtil(0,n);
    }
    
    public boolean solUtil(int index,int n){
        
        if(Math.pow(4,index)>n) return false;
        if(Math.pow(4,index)==n) return true;
        
        return solUtil(index+1,n);
        
    }
}