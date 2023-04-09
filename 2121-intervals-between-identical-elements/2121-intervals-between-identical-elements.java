/*

Logic : https://leetcode.com/problems/sum-of-distances/discuss/3395726/Explained-with-images-oror-Easy-to-understand

Similar q : https://leetcode.com/problems/sum-of-distances/


*/


class Solution {
    public long[] getDistances(int[] nums) {
        long[] ans=new long[nums.length];

        Map<Integer,List<Integer>> mp=new HashMap<>();


        for(int i=0;i< nums.length;i++){
            List<Integer> list = mp.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            mp.put(nums[i], list);
        }

        for(Map.Entry<Integer,List<Integer>> ele:mp.entrySet()){

            int key=ele.getKey();
            List<Integer> tempList=ele.getValue();

            long totalSum=0l;

            for(int x:tempList) totalSum+=(long)x;

            long preSum=0l;

            for(int i=0;i<tempList.size();i++){

                int index=tempList.get(i);

                long postSum=totalSum-preSum-index;

                ans[index]+=(index * (long)i);
                ans[index]-=(preSum);
                ans[index]-=(index * (long)(tempList.size() - i -1));
                ans[index]+=postSum;

                preSum +=index;
            }
        }

        return ans;
    }
}