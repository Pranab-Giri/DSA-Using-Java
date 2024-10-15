class Solution {
    public long minimumSteps(String s) {
        long swaps = 0;  // Total number of swaps needed
        long zeroCount = 0;  // Count of '0's encountered so far

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                zeroCount++;  // Increment the count of '0's
            } else {
                // Add the number of '0's seen so far, as each '1' needs to swap with these '0's
                swaps += zeroCount;
            }
        }

        return swaps;
    }
}


