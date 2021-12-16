

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        
         int max = candies[0];
        
        for(int y:candies){
            if(y>max){
                max=y;
            }
        }
        
        for(int x:candies){
            if((x + extraCandies) >= max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        
        return result;
    }
}