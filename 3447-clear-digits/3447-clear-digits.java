class Solution {
    public String clearDigits(String s) {
        // Initialize a stack to store the characters
        Stack<Character> stack = new Stack<>();
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If the character is a digit, pop the stack (remove the closest non-digit character)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // If the character is not a digit, push it onto the stack
                stack.push(c);
            }
        }
        
        // Convert the stack to a string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // The result is in reverse order, so reverse it before returning
        return result.reverse().toString();
    }
}
