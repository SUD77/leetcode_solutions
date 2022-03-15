class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        Map<Character,Integer> temp=new HashMap<>();
        
        char[] ch=s.toCharArray();
        
        for(int i=0;i<ch.length;i++) {
        	temp.put(ch[i],temp.getOrDefault(ch[i],0)+1);
        }
        
        System.out.println(temp);
  
        int count=temp.get(ch[0]);
        for(char x:ch) {
        	if(temp.get(x)!=count) {
        		return false;
        	}
  
        }
        
        return true;
        
    }
}