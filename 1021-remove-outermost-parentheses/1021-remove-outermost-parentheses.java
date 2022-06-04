class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder ans=new StringBuilder();
        Deque<Character> temp=new LinkedList<>();
        
        char[] c=s.toCharArray();


        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){

                if(temp.size()>0){
                    ans.append(s.charAt(i));
                }
                temp.addFirst(s.charAt(i));

            }else{

                if(temp.size()>1){
                    ans.append(s.charAt(i));
                }
                temp.removeFirst();
            }
        }
        
        return ans.toString();
    }
}