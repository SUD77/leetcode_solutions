/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/3686980/From-Dumb-to-Pro-with-Just-One-Visit-My-Promise-to-You-with-Efficient-Selection-of-k-Smallest-Pair

Time Complexity:

Constructing the initial pairs and pushing them into the priority queue takes O(n1) time, where n1 is the size of nums1.
The while loop executes at most k times or until the priority queue becomes empty. In each iteration, extracting the smallest pair, adding it to the result vector, and pushing the next pair (if available) into the priority queue takes O(log k) time.
Therefore, the overall time complexity can be approximated as $O(n + k log k)$, where n is the size of nums1 and k is the given parameter.

Space Complexity:

Result vector resV and priority queue pq.
Result vector resV will contain at most k pairs, i.e occupies O(k) space.
Priority queue pq can hold at most k pairs as well, i.e O(k) space.
Thus, SC =  O(k)
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Priority queue to store pairs with smallest sums, sorted by the sum

        // Push the initial pairs into the priority queue
        for (int x : nums1) {
            pq.offer(new int[]{x + nums2[0], 0}); // The sum and the index of the second element in nums2
        }

        // Pop the k smallest pairs from the priority queue
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0]; // Get the smallest sum
            int pos = pair[1]; // Get the index of the second element in nums2

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            resV.add(currentPair); // Add the pair to the result list

            // If there are more elements in nums2, push the next pair into the priority queue
            if (pos + 1 < nums2.length) {
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--; // Decrement k
        }

        return resV; // Return the k smallest pairs
    }
}