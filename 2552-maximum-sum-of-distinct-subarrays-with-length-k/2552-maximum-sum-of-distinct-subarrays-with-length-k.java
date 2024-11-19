import java.util.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    // Initialize variables
        long maxSum = 0;
        long currentSum = 0;
        int n = nums.length;
        HashSet<Integer> uniqueElements = new HashSet<>();

        // Sliding window approach
        for (int i = 0; i < n; i++) {
            // Add the current element to the window
            currentSum += nums[i];

            // Ensure the element is unique in the window
            while (uniqueElements.contains(nums[i])) {
                int start = nums[i - (uniqueElements.size())];
                currentSum -= start;
                uniqueElements.remove(start);
            }

            // Add current element to the set
            uniqueElements.add(nums[i]);

            // If the window size exceeds k, slide the window
            if (uniqueElements.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
                // Slide the window by removing the leftmost element
                int start = nums[i - k + 1];
                currentSum -= start;
                uniqueElements.remove(start);
            }
        }

        return maxSum;
    }
}