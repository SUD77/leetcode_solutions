class Solution {
    public int[] intersection(int[] words1, int[] words2) {
        
        
        int count=0;
		
		Map<Integer,Integer> temp1=new HashMap<>();
		Map<Integer,Integer> temp2=new HashMap<>();
		
		for(int x:words1) {
			temp1.put(x, temp1.getOrDefault(x,0)+1);
		}
		
		for(int x:words2) {
			temp2.put(x, temp2.getOrDefault(x,0)+1);
		}
		
//		for(int x:words1) {
//			if(temp2.containsKey(x)==true) {
//				count++;
//			}
//		}
		
		for(Map.Entry x:temp1.entrySet()) {
			int key=(int)x.getKey();
			if(temp2.containsKey(key)==true) {
				count++;
			}
		}
		
		int[] result=new int[count];
		int i=0;
		
		for(Map.Entry x:temp1.entrySet()) {
			int key=(int)x.getKey();
			if(temp2.containsKey(key)==true) {
				result[i++]=key;
			}
		}
		
		//System.out.println(count);
		
		// for(int x:result) {
		// 	System.out.println(x);
		// }
        
        
	
	 return result;
        
    }
}