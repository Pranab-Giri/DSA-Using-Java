class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // Track occurrences of consecutive characters
        
        result.append(s.charAt(0)); // Add the first character to result

        // Loop through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // Increment count if the character is the same as the previous one
            } else {
                count = 1; // Reset count if the character is different
            }

            // Only add the character if count is less than 3
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
