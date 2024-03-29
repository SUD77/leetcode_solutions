//https://leetcode.com/problems/reducing-dishes/discuss/563384/JavaC%2B%2BPython-Easy-and-Concise

class Solution {
    public int maxSatisfaction(int[] A) {
        
        Arrays.sort(A);
        int res = 0, total = 0, n = A.length;
        for (int i = n - 1; i >= 0 && A[i] > -total; --i) {
            total += A[i];
            res += total;
        }
        return res;
    }
}