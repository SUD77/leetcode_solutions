class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] ch1=word1.toCharArray();
		char[] ch2=word2.toCharArray();
		
		int i=0,j=0;
		
		int n=word1.length();
		int m=word2.length();
		
		StringBuilder sb=new StringBuilder();
		
		while(i<n && j<m) {
			sb.append(ch1[i++]);
			sb.append(ch2[j++]);
		}
		
		while(i<n) {
			sb.append(ch1[i++]);
		}
		
		while(j<m) {
			sb.append(ch2[j++]);
		}
		
		//System.out.println(sb.toString().getClass().getSimpleName());
        
        return sb.toString();
    }
}