class Solution {
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }

        //Divide 2, 3, and 5 as long as it is divisible by them

        while(n % 2 == 0){
            n /=2;
        }
        while(n % 3 == 0){
            n /=3;
        }
        while(n % 5 == 0){
            n /=5;
        }

        return n == 1;

    }
}