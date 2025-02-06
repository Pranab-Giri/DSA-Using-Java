class Solution {
    public int tupleSameProduct(int[] nums) {
         Map<Integer, Integer> productCount = new HashMap<>();
        int count = 0;
        
        // Compute all possible products and store their frequency
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }
        
        // Count the valid tuples
        for (int freq : productCount.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8; // Each pair can form 8 permutations
            }
        }
        
        return count;
    }
}