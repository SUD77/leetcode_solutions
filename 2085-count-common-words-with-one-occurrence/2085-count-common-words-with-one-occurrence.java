class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        	int count=0;
		
		Map<String,Integer> temp1=new HashMap<>();
		Map<String,Integer> temp2=new HashMap<>();
		
		for(String x:words1) {
			temp1.put(x, temp1.getOrDefault(x,0)+1);
		}
		
		for(String x:words2) {
			temp2.put(x, temp2.getOrDefault(x,0)+1);
		}
		
		for(String x:words1) {
			if(temp2.containsKey(x)==true) {
				
				if(temp1.get(x)==1 && temp2.get(x)==1) count++;
			}
		}
		
		//System.out.println(count);
        
        return count;
    }
}