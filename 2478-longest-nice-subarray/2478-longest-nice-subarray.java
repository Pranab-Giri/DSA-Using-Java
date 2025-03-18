class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;  // Left pointer for sliding window
        int orMask = 0; // Bitwise OR of the current subarray
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // While the bitwise AND is non-zero, shrink from the left
            while ((orMask & nums[right]) != 0) {
                orMask ^= nums[left]; // Remove nums[left] from OR mask
                left++;  // Move left pointer forward
            }

            // Add nums[right] to OR mask
            orMask |= nums[right];

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
