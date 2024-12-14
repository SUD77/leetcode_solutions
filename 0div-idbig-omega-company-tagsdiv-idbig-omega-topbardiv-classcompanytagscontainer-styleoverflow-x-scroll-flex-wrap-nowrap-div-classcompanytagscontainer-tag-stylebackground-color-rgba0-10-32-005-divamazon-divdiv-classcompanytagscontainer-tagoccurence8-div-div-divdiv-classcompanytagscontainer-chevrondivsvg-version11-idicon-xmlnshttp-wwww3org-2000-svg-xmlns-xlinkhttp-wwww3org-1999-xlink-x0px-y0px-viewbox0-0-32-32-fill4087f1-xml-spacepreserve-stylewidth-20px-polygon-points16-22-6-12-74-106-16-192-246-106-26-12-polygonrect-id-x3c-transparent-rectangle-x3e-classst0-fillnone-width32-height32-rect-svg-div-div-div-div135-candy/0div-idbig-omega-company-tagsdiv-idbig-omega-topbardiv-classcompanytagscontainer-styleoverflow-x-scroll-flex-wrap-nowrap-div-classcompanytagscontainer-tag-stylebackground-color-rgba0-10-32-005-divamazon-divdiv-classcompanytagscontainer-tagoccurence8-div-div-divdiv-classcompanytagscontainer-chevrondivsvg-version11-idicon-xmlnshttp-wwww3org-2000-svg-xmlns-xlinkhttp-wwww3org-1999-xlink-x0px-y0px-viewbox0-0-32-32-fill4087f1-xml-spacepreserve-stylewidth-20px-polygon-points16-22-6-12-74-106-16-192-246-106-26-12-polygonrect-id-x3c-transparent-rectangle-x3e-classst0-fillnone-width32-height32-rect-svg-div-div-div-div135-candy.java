class Solution {
    public int candy(int[] ratings) {
        
        int n=ratings.length;
        int minCandy=0;
        
        int[] score=new int[n];
        
        Arrays.fill(score,1);
        
        //left iteration
        for(int i=1;i<n;i++){
            
            if(ratings[i-1]<ratings[i]){
                score[i]=score[i-1]+1;
            }
            
        }
        
        
        for(int i=n-2;i>=0;i--){
            
            if(ratings[i]>ratings[i+1]){
                score[i]=Math.max(score[i+1]+1,score[i]);
            }
        }
        
        
        for(int x:score){
            minCandy+=x;
        }
        
        return minCandy;
    }
}