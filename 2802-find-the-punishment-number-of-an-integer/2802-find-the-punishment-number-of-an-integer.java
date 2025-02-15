class Solution {
    public int punishmentNumber(int n) {
        int totalSum = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = String.valueOf(square);

            // Use backtracking to check if it's a valid number
            if (canPartition(squareStr, 0, i, 0)) {
                totalSum += square;
            }
        }
        return totalSum;
    }

    private boolean canPartition(String s, int index, int target, int currentSum) {
        // If we reached the end of the string, check if the sum matches the target
        if (index == s.length()) {
            return currentSum == target;
        }

        int num = 0;
        for (int j = index; j < s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0');

            // If current sum + num exceeds target, break early
            if (currentSum + num > target) break;

            // Recurse for the next substring
            if (canPartition(s, j + 1, target, currentSum + num)) {
                return true;
            }
        }
        return false;
    }
}
