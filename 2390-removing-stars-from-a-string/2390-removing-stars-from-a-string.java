class Solution {
    public String removeStars(String s) {
        
        
       Stack<Character> st=new Stack<>();
        
       for(char ch:s.toCharArray()){
           
           if(ch!='*') st.push(ch);
           else{
               if(st.size()>0) st.pop();
           }
       }
        
        String ans="";
        
        while(st.size()>0){
            ans+=st.pop();
        }
        
        return new StringBuilder(ans).reverse().toString();
    }
}