class Solution {
    public int largestAltitude(int[] gain) {
        
//         ArrayList<Integer> temp = new ArrayList<Integer>();
        
//         temp.add(0);
        
        
        int[] temp=new int[gain.length+1];
        temp[0]=0;
        
        int i=1;
        
        for(int j=0;j<gain.length;j++ ){
            temp[i]=temp[i-1]+gain[j];
            i++;
        }
        
        
        int max=temp[0];
        
        for(int k=1;k<temp.length;k++){
            if(temp[k]>max){
                max=temp[k];
            }
        }
        
        return max;
        
    }
}