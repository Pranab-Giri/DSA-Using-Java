import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Create a frequency array to count remainders
        int[] remainderCounts = new int[k];
        
        // Count frequencies of remainders
        for (int num : arr) {
            // Ensure remainder is non-negative
            int remainder = ((num % k) + k) % k;
            remainderCounts[remainder]++;
        }
        
        // Check the conditions for pairing
        for (int i = 1; i < k; i++) {
            if (remainderCounts[i] != remainderCounts[k - i]) {
                return false;
            }
        }
        
        // Special case: Remainders that are exactly divisible by k (i.e., remainder 0)
        if (remainderCounts[0] % 2 != 0) {
            return false;
        }
        
        return true;
    }
}
