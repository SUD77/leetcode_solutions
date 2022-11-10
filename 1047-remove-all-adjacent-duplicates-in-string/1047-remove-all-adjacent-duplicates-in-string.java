class Solution {
    public String removeDuplicates(String s) {
        
        
        Stack<Character> x=new Stack<>();

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){

            if(x.isEmpty()){
                x.add(s.charAt(i));
            }else{
                if(x.peek()==s.charAt(i)) x.pop();
                else x.add(s.charAt(i));
            }

        }

        while(!x.isEmpty()){
            sb.append(x.pop());
        }

        
        return sb.reverse().toString();
    }
}