class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        
        
        int[] tempArr=nextGreaterElement(nums2,nums2.length);
        int[] ans=new int[nums1.length];
        
        int i=0;
        for(int x:nums1){
            int idx=map.get(x);
            ans[i++]=tempArr[idx];
        }
        
        
        return ans;
    }
    
    public static int[] nextGreaterElement(int[] arr, int n) {
        // Write your code here.
        int[] ans=new int[arr.length];

        Stack<Integer> st=new Stack<>();
        st.push(arr[n-1]);
        ans[n-1]=-1;

        for(int i=n-2;i>=0;i--){


            while(!st.isEmpty() && st.peek()<=arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) ans[i]=-1;
            else if(st.peek()>arr[i]){
                ans[i]=st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
    }
}