// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/discuss/477690/JavaPython-3-Bit-manipulation-w-explanation-and-analysis.

class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount(c ^= (a | b)) + Integer.bitCount(a & b & c);
    }
}