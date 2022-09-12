class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        
        int leftPtr=0;
        int rightPtr=tokens.length-1;
        
        int score=0;
        
        while(leftPtr<=rightPtr){
            
            if(power>=tokens[leftPtr]){
                
                power -= tokens[leftPtr++];
                score++;
                
            }else{
                if(power + tokens[rightPtr] >=tokens[leftPtr] && score !=0 && rightPtr!=leftPtr){
                    
                    power += tokens[rightPtr--];
                    score--;
                }else{
                    break;
                }
            }
        }
        
        return score;
    }
}