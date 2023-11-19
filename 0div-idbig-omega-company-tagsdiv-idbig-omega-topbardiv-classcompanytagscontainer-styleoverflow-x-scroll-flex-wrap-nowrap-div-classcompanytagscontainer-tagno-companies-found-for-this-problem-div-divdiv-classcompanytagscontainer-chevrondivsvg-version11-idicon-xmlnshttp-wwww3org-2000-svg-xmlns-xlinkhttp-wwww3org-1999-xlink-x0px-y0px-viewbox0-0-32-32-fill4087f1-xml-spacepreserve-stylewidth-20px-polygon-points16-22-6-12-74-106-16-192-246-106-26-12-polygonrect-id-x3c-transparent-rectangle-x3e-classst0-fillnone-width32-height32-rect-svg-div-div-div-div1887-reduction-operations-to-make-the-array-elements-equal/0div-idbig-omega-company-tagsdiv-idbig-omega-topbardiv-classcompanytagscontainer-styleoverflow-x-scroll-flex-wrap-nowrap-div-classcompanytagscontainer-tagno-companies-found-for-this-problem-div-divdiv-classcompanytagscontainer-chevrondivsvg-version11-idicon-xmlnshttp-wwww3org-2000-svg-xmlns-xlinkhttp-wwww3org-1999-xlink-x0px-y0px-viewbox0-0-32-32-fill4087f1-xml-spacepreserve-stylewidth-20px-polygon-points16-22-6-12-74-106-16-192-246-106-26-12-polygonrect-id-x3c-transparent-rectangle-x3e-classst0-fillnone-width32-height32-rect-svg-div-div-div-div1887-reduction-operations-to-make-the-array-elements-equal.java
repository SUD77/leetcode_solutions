//https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/discuss/4303974/JavaPython-3-Simulation-by-TreeMap-Counter-w-brief-explanation-and-analysis.
class Solution {
    public int reductionOperations(int[] nums) {
        
        TreeMap<Integer, Integer> frequencies = new TreeMap<>();
        for (int n : nums) {
         // frequencies.merge(n, 1, Integer::sum);
            frequencies.put(n, 1 + frequencies.getOrDefault(n, 0));
        }
        int operations = 0, freqOfNextLargest = 0;
        while (frequencies.size() > 1) {
            Map.Entry<Integer, Integer> e = frequencies.pollLastEntry();
            freqOfNextLargest += e.getValue();
            operations += freqOfNextLargest;
        }
        return operations;
    }
}