// I did the code myself, but understood the algo from here somewhere else

class Solution {
    public String removeDuplicates(String s, int k) {
        
        
        Stack<CharCounter> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
        
            char c=s.charAt(i);
            
            if(!st.isEmpty() && c==st.peek().c){
                
                if(st.peek().count==k-1){
                    st.pop();
                }else{
                    st.peek().count++;
                }
                
            }else{
                st.push(new CharCounter(c));
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(CharCounter charCounter:st){
            
            int freq=charCounter.count;
            
            int i=0;
            while(i<freq){
                sb.append(charCounter.c);
                i++;
            }
        }
        
        return sb.toString();
    }
    
    class CharCounter{
        char c;
        int count;
        
        CharCounter(char c){
            this.c=c;
            this.count=1;
        }
    }
}