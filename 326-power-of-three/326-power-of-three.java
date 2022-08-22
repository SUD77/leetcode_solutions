class Solution {
    public boolean isPowerOfThree(int n) {
        
        return solUtil(0,n);
    }
    
    public boolean solUtil(int index,int n){
        
        if(Math.pow(3,index)>n) return false;
        if(Math.pow(3,index)==n) return true;
        
        return solUtil(index+1,n);
        
    }
}