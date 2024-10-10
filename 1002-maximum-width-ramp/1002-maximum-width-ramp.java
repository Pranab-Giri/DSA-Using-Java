import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        // Create a list of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the indices based on the values in nums
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int maxWidth = 0;
        int minIndex = n;

        // Iterate through sorted indices and compute the maximum width
        for (int index : indices) {
            // Update the minimum index encountered so far
            maxWidth = Math.max(maxWidth, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }

        return maxWidth;
    }
}
