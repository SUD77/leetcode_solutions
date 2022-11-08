class Solution {
    public String makeGood(String s) {
        
       Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        st.add(s.charAt(0));

        for(int i=1;i<s.length();i++){

            char temp=s.charAt(i);


            if(!st.isEmpty() && Character.isUpperCase(temp) && st.peek()==Character.toLowerCase(temp)){
                st.pop();
            }else if(!st.isEmpty() && Character.isLowerCase(temp) && st.peek()==Character.toUpperCase(temp)){
                st.pop();
            }
            else{
                st.add(temp);
            }


        }

        while (!st.isEmpty()){
            sb.append(st.pop());
        }


        return sb.reverse().toString();
    }
}