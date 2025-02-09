import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2; // Total pairs in the array

        HashMap<Integer, Integer> map = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            int diff = i - nums[i];

            // Count the number of previous occurrences of this diff
            if (map.containsKey(diff)) {
                goodPairs += map.get(diff);
            }

            // Update frequency of the current diff
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}
