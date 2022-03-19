class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum=0;
		
		List<Integer> dig=new ArrayList<>();
		
		for(int i=1;i<=num/2;i++) {
			if(num%i==0) dig.add(i); 
		}
		
		for(Integer x:dig) {
			sum=sum+x;
		}
		
		if(sum==num) return true;
        
        return false;
    }
}