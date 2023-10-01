class Solution {
    public String reverseWords(String s) {
        
        char[] ch=s.toCharArray();
        
        for(int i=0; i< ch.length;i++){
            
            if(ch[i]!=' '){
                int j = i;
                while(j + 1 < ch.length && ch[j+1] !=' '){j++; }
                reverse(ch,i,j);
                i = j;
                    
            }
        }
        
        return new String(ch);
    }
    
    private void reverse(char[] ch,int i, int j){
        
        for(; i<j; i++, j--){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
        }
    }
}