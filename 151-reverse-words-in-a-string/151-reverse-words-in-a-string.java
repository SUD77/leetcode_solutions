class Solution {
    public String reverseWords(String s) {
        
        s=s.replaceAll("\\s+"," ");
        s=s.trim();
        
        String[] ch=s.split(" ");
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=ch.length-1;i>=0;i--){
            String x=ch[i];
            x=x.trim();
            sb.append(x+" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}