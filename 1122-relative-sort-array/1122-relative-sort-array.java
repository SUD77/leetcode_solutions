class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
      Map<Integer,Integer> temp=new TreeMap<>();
		
		
		
		
		int[] result=new int[arr1.length];
		
		for(int x:arr1) {
			temp.put(x, temp.getOrDefault(x, 0)+1);
		}
		
		//System.out.println(temp);
		
		int i=0;
	
		for(int x:arr2) {
			
			if(temp.containsKey(x)) {
				for(int j=0;j<temp.get(x);j++) {
					result[i++]=x;
				}
			}
			
			temp.remove(x);
		}
		
		Arrays.sort(arr1);
		
		for(int x:temp.keySet()) {
				for(int j=0;j<temp.get(x);j++) {
					result[i++]=x;
				}
			
		}
		
		
		return result;
    }
}