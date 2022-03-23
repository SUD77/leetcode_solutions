class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        Map<Integer,Integer> temp=new HashMap<>();
		int res=0;
        
		for(int i=lowLimit;i<=highLimit;i++) {
			int sum=sumof(i);
			
			temp.put(sum, temp.getOrDefault(sum,0)+1);
            res = Math.max(res, temp.get(sum));
		}
		
		//System.out.print(temp);
		
		//int maxValueInMap = (Collections.max(temp.values()));
		
		//System.out.println(maxValueInMap);
        
        return res;
        
    }
    
    public int sumof(int num) {
		int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
	}
	
}