class Solution {
    public int sumOfUnique(int[] nums) {
        
        
        int sum=0;
		
		Map<Integer,Integer> temp=new HashMap<>();
		
		for(int x:nums) {
			temp.put(x, temp.getOrDefault(x,0)+1);
		}
		
		
		
		for(int x:nums) {
			if(temp.get(x)==1) sum+=x;
		}
        
        return sum;
    }
}