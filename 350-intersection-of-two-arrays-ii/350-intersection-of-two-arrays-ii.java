class Solution {
    public int[] intersect(int[] words1, int[] words2) {
        
        
        int count=0;
		
		Map<Integer,Integer> temp1=new HashMap<>();
		Map<Integer,Integer> temp2=new HashMap<>();
		
        
        //Putting the value of first array in hashmap
		for(int x:words1) {
			temp1.put(x, temp1.getOrDefault(x,0)+1);
		}
        
		//Putting the value of second array in hashmap
		for(int x:words2) {
			temp2.put(x, temp2.getOrDefault(x,0)+1);
		}
		
		
        //Checking if key is present in both and how many times, so that we can set the size fo array accordingly. 
		for(Map.Entry x:temp1.entrySet()) {
			int key=(int)x.getKey();
			if(temp2.containsKey(key)==true) {
				count=count+Math.min(temp1.get(key), temp2.get(key));
			}
		}
		
        
        //Initalizing array and setting the sixe
		int[] result=new int[count];
		int i=0;
		
        
        
        //Iteratign through hashamp and fillling the array accordingly.
		for(Map.Entry x:temp1.entrySet()) {
			int key=(int)x.getKey();
			if(temp2.containsKey(key)==true) {
				int min=Math.min(temp1.get(key), temp2.get(key));
				int counter=0;
				while(counter<min) {
					result[i++]=key;
					counter++;
				}
			}
		}
		
        
        return result;
        
    }
}