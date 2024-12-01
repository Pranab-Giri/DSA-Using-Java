class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if the strings have the same length
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if 'goal' is a substring of 's + s'
        return (s + s).contains(goal);
    }
}
