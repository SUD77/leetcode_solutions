class Solution {
    public int countAsterisks(String s) {
       
        Stack<Character> st=new Stack<>();
        int count=0;

        for(int i=0;i<s.length();i++){

            if(st.isEmpty()){
                if(s.charAt(i)=='|'){
                    st.push(s.charAt(i));
                }else if(s.charAt(i)=='*') count++;
            }else if(!st.isEmpty()){
                if(s.charAt(i)=='|') st.pop();
            }
        }
        
        return count;
    }
}