class Solution {
    public String reverseWords(String s) {
        String[] str=s.split(" ");
        
        StringBuilder sb=new StringBuilder();
        
        System.out.println(Arrays.toString(str));
        
       for(int i=str.length-1;i>=0;i--){
           if(!str[i].equals(" ") && !str[i].equals("")) {
                sb.append(str[i]);
                if(i!=0) sb.append(" ");
            }
       }
        
        // System.out.println(sb.toString());
        
        return sb.toString().trim();
    }
}