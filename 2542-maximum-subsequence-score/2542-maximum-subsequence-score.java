// https://leetcode.com/problems/maximum-subsequence-score/discuss/3558130/JAVA-oror-100-Heap-%2B-Sort-oror-Clean-and-Fast-Solutions

class Solution {
     public long maxScore(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        int n = nums1.length;

        // k = 1 base case
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                long cur = (long) nums1[i] * nums2[i];
                ans = Math.max(ans, cur);
            }
            return ans;
        }

        // k > 1 cases
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] {nums1[i], nums2[i]};

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        Queue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            int num1 = arr[i][0];
            if (i <= n - k) {
                long cur = (sum + num1) * arr[i][1];
                ans = Math.max(ans, cur);
            }
            if (queue.size() < k - 1) {
                queue.add(num1);
                sum += num1;
            } else if (num1 > queue.peek()) {
                sum -= queue.poll();
                sum += num1;
                queue.add(num1);
            }
        }
        return ans; 
    }
}