//TC = O(n x n) to find factorial * then in each iteartion removing element from list
//SC = O(N)

class Solution {
    public String getPermutation(int n, int k) {
        
        List<Integer> numberList = new ArrayList<>();
        
        int fact = 1; //fact calculating only till 3!
        for(int i=1; i<n; i++){
            fact = fact * i;
            numberList.add(i);
        }
        numberList.add(n); //creating numberList array as {1,2,3,4}
        
        
        // fact = 3! = 1 x 2 x 3 = 6
        // k = 17-1 = 16
        
        k = k - 1;  //take k as 0-based indexing
        String ans = "";
        while(true){
            ans += numberList.get(k / fact); // getting number as numList[ 16 / 6]
            numberList.remove(k / fact); //removing that number from numList
            
            if(numberList.size() == 0 ) break;
            
            k = k % fact; //16 % 6
            fact = fact / numberList.size(); //  (3 x 2 x 1) / (3)
        }        
        return ans;
	}
}