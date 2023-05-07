class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
      
        int low=-1;
        int high=letters.length;
        
        while(low+1<high){
            int mid=low+ (high - low)/2;
            
            if(isGreaterThanOrEqual(letters[mid],target)){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        //System.out.println(letters[high]);
        
        if(high==letters.length) return letters[0];
        
        return letters[high];
    }
    
    public boolean isGreaterThanOrEqual(char letter,char target){
        return letter>target;
    }
}