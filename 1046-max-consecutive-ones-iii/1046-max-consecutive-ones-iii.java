class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int right = 0;
        int left = 0, zeros = 0;
        for(right = 0; right< nums.length; right++){
            //If we counter a zero then, Increase the zero by 1
            if(nums[right] == 0){
                zeros++;
            }
            while(zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}