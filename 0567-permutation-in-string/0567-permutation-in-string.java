class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize the frequency array for s1 and the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Count how many different characters are there between s1Count and s2Count
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                diff++;
            }
        }

        // If no difference, we found a permutation match
        if (diff == 0) {
            return true;
        }

        // Start sliding the window across s2
        for (int i = s1.length(); i < s2.length(); i++) {
            int newCharIndex = s2.charAt(i) - 'a';
            int oldCharIndex = s2.charAt(i - s1.length()) - 'a';

            // Add the new character into the window
            s2Count[newCharIndex]++;
            if (s2Count[newCharIndex] == s1Count[newCharIndex]) {
                diff--;  // Characters match now
            } else if (s2Count[newCharIndex] == s1Count[newCharIndex] + 1) {
                diff++;  // Characters no longer match
            }

            // Remove the old character from the window
            s2Count[oldCharIndex]--;
            if (s2Count[oldCharIndex] == s1Count[oldCharIndex]) {
                diff--;  // Characters match now
            } else if (s2Count[oldCharIndex] == s1Count[oldCharIndex] - 1) {
                diff++;  // Characters no longer match
            }

            // If no difference, we found a permutation match
            if (diff == 0) {
                return true;
            }
        }

        return false;
    }
}
