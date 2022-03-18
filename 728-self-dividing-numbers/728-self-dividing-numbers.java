class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> result=new ArrayList<>();
		
		for(int x=left;x<=right;x++) {
			if(fun1(x)) result.add(x);
		}
		
		// for(Integer x:result) {
		// 	System.out.println(x);
		// }
        
        return result;
    }
    
    	public  boolean fun1(int num) {
		int temp=num;
		
		List<Integer> dig=new ArrayList<Integer>();
		
		while(temp>0) {
			int temp2=temp%10;
			dig.add(temp2);
			temp=temp/10;
		}
		
		for(Integer x:dig) {
			if(x==0) return false;
			if(num%x!=0) return false;}
		
		return true;
	}
}