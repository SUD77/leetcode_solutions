class Solution {
    public int maximum69Number (int num) {
        int i=0;
        int temp=num;
        int index_six=-1;
        
        while(temp>0){
            if(temp%10 == 6) index_six=i;
            temp=temp/10;
            i+=1;
        }
        
        if(index_six!= -1) {
            return (num+ (int)(3* Math.pow(10,index_six)));
        }
        
        return num;
        
    }
}