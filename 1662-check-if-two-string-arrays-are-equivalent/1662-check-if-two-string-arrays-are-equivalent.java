class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String temp="";
		String temp2="";
		
		for(String x:word1) {
			temp=temp+x;
		}
		
		for(String y:word2) {
			temp2=temp2+y;
		}
		
		//System.out.println(temp.equals(temp2));
        return temp.equals(temp2);
        
    }
}