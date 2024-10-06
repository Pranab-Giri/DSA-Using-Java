class Solution {
    public int missingNumber(int[] arr) {
      int n = arr.length;

      int totalSum = (n)*(n+1)/2;
      for(int i=0; i<arr.length; i++){
        totalSum -=arr[i];
      }
      return totalSum;
    }
}