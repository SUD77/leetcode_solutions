class Solution {
    public void nextPermutation(int[] data) {
                
        if(data==null || data.length <=1) return;
        
        int i=data.length-2;
        
        while(i >=0 && data[i]>=data[i+1]) i--;
        
        if(i>=0){
            int j=data.length-1;
            while(data[j] <=data[i]) j--;
            swap(data,i,j);
        }
        
        reverse(data,i+1,data.length-1);
    }
    
    public void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    
    public void reverse(int[] data,int i,int j){
        while(i<j) swap(data,i++,j--);
    }
}