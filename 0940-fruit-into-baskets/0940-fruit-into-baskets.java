class Solution {
    public int totalFruit(int[] fruits) {
         // HashMap to store the fruit type and its frequency in the current window
        HashMap<Integer, Integer> basket = new HashMap<>();
        
        int maxFruits = 0;  // To store the maximum number of fruits we can pick
        int left = 0;       // Left pointer of the sliding window
        
        // Iterate over the fruits array with the right pointer
        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the basket
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            
            // If the number of fruit types in the basket exceeds 2, shrink the window
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                
                // Remove the fruit type from the basket if its count becomes 0
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                
                // Move the left pointer to shrink the window
                left++;
            }
            
            // Update the maximum number of fruits that can be picked
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}