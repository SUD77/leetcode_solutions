class Solution {
    public int percentageLetter(String s, char letter) {


        char[] temp=s.toCharArray();

        int count=0;

        for(char x:temp){
            if(x==letter){
            count++;
            }
        }

        int size=temp.length;

        int val= (int) ((((double)count/(double) size)*100)) ;


        return val;
    }
}