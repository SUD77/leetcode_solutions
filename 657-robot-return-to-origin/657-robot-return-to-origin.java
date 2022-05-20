class Solution {
    public boolean judgeCircle(String moves) {
        
        //Storing the cahracters of moves in this array. So that I can access one word at a time.
        char[] temp=moves.toCharArray();
        
        /* Logic is simple, as left is -x axis, so -1 everytime we go left.
        Similarly, right is +x axis, U is +y axis and D is -y axis.
        */
        int Xsum=0;
        int Ysum=0;
        
        for(char x:temp){
            
            if(x=='L'){
                Xsum--;
            }else if(x=='R'){
                Xsum++;
            }else if(x=='U'){
                Ysum++;
            }else if(x=='D'){
                Ysum--;
            }else{
                Xsum=Xsum+0;
                Ysum=Ysum+0;
            }
        }
        
        if(Xsum==0 && Ysum==0) return true;
        
        return false;
        
    }
}