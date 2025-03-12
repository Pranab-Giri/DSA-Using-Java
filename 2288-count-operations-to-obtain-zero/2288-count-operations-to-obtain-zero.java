class Solution {
    public int countOperations(int num1, int num2) {
        return helper(num1,num2,0);
    }

    private static int helper(int n1, int n2, int steps){
        if(n1 == 0 || n2 == 0){
            return steps;
        }

        if(n1>=n2){
            return helper(n1-n2, n2, steps+1);
        }
        return helper(n1, n2-n1, steps+1);
    }
}