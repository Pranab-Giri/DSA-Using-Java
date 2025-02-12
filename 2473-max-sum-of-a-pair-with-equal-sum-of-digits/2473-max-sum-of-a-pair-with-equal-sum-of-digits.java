import java.util.*;

class Solution {
    static int addDigits(int num){
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> sumToMax = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = addDigits(num);

            if (sumToMax.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, num + sumToMax.get(digitSum));
            }

            sumToMax.put(digitSum, Math.max(sumToMax.getOrDefault(digitSum, 0), num));
        }

        return maxSum;
    }
}



/*Brute force solution */
// class Solution {
//     static int addDigits(int num){
//         int temp = num;
//         int sum = 0;
//         while(temp != 0){
//             int digit = temp % 10;
//             sum += digit;
//             temp /= 10;
//         }
//         return sum;
//     }
//     public int maximumSum(int[] nums) {
//         int maxSum = -1;
//         for(int i=0; i<nums.length-1; i++){
//             int fast = nums[i];
//             for(int j=i+1; j<nums.length; j++){
//                 int last = nums[j];
//                 if(i != j){
//                     if(addDigits(fast) == addDigits(last)){
//                     if(maxSum < (nums[i]+nums[j])){
//                         maxSum = nums[i]+nums[j];
//                     }
//                 }
//                 }
//             }
//         }
//         return maxSum;
//     }
// }