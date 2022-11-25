class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int n = arr.length;
    
    int NS[] = new int [n];
    int PS[] = new int [n];
    
	//for base case: when is there is no smallest element in the left or right
    for(int i =0; i<n; i++){
        NS[i] = n-i-1;
        PS[i] = i;
    }
    //find next smallest
    for(int i=0; i<n; i++){
        while(!stack1.empty() && arr[stack1.peek()] > arr[i]){
            NS[stack1.peek()] = i-stack1.peek() -1;
            stack1.pop();
        }
        stack1.push(i);
    }
    //find prev amallest
    for(int i=n-1; i>=0; i--){
        while(!stack2.empty() && arr[stack2.peek()] >= arr[i]){
            PS[stack2.peek()] = stack2.peek() -i-1;
            stack2.pop();
        }
        stack2.push(i);
    }
  
    long ans =Long.valueOf(0);
    for(int i =0; i<n; i++){
        long left = PS[i] +1;
        long right = NS[i] +1;
        ans += (arr[i]*left*right);
    }
    return (int)(ans %(Math.pow(10,9) +7));
    }
}