// https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/3960512/VideoEx-Amazon-explains-a-solution-with-Python-JavaScript-Java-and-C%2B%2B

class Solution {
    public int findLongestChain(int[][] pairs) {
         Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int[] prev = pairs[0];
        int res = 1;

        for (int i = 1; i < pairs.length; i++) {
            int[] cur = pairs[i];
            if (cur[0] > prev[1]) {
                res++;
                prev = cur;
            }
        }

        return res; 
    }
}