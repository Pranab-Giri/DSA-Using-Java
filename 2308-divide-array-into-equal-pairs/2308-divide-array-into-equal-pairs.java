class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums); //Sort the array

        for(int i=0; i<nums.length; i+=2){
            if(nums[i] != nums[i+1]){//if the current is not equal with the next element then it should retun false otherwise return true
                return false;
            }
        }
        return true;
    }
}