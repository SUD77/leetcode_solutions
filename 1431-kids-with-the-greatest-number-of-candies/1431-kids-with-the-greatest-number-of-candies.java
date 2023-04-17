//TC - O(n)
//SC - O(n)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int currMax=Integer.MIN_VALUE;
        List<Boolean> result=new ArrayList<>();
        
        for(int x:candies){
            currMax=Math.max(currMax,x);
        }
        
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies >=currMax){
                result.add(i,true);
            }else{
                result.add(i,false);
            }
        }
        
        return result;
        
    }
}