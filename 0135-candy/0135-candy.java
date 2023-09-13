class Solution {
    public int candy(int[] ratings) {
        
        int n=ratings.length;
        int[] left=new int[n];
        
        
        Arrays.fill(left,1);
        
        for(int i=1;i<n;i++){
            
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
        }
        
        int right=1;
        
        for(int j=n-2;j>=0;j--){
            
            if(ratings[j]>ratings[j+1]){
                
                right++;
                left[j]= Math.max(left[j],right);
            }else{
                right=1;
            }
                
        }
        
        int sum=0;
        
        for(int x:left){
            sum+=x;
        }
        
        return sum;
        
    }
}