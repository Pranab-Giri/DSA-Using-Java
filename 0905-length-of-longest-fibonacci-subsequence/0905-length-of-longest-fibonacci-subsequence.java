import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        // Store indices of elements in arr for quick lookup
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate through all pairs (arr[j], arr[k])
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int x = arr[k] - arr[j]; // Find the missing first element in sequence
                if (indexMap.containsKey(x) && indexMap.get(x) < j) { // Check if it's a valid sequence
                    int i = indexMap.get(x);
                    int key = i * n + j; // Create a unique key for dp map
                    int len = dp.getOrDefault(key, 2) + 1;
                    dp.put(j * n + k, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0; // If no valid sequence found, return 0
    }
}
