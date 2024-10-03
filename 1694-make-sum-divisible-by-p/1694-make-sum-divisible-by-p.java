import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        // Step 1: Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Step 2: Calculate totalSum % p, this is the remainder we need to eliminate
        int remainder = (int)(totalSum % p);
        if (remainder == 0) {
            return 0; // No need to remove anything
        }
        
        // Step 3: Use a hashmap to track prefix sums modulo p
        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1); // Prefix sum 0 at index -1 (before the start of the array)
        int prefixSum = 0;
        int minLen = n;
        
        for (int i = 0; i < n; i++) {
            // Update the prefix sum modulo p
            prefixSum = (prefixSum + nums[i]) % p;
            
            // We want to find (prefixSum - remainder) % p == 0
            int target = (prefixSum - remainder + p) % p;
            
            // Check if this target exists in the map
            if (prefixModMap.containsKey(target)) {
                minLen = Math.min(minLen, i - prefixModMap.get(target));
            }
            
            // Store the current prefix sum modulo p in the map
            prefixModMap.put(prefixSum, i);
        }
        
        // Step 4: If we didn't find any valid subarray, return -1
        return minLen == n ? -1 : minLen;
    }
}
