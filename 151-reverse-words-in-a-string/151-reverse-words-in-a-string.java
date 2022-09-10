class Solution {
    public String reverseWords(String s) {
        
        // this removes the extra space inside the sentences
        s=s.replaceAll("\\s+"," ");

        //this removes the leading and trailing spaces
        s=s.trim();

        String[] ch=s.split(" ");

        StringBuilder sb=new StringBuilder();

        for(int i= ch.length-1;i>=0;i--){
            String x=ch[i];
            x=x.trim();
            sb.append(x+" ");
        }

        sb.deleteCharAt(sb.length()-1);
        
        
        return sb.toString();
        
        
    }
}