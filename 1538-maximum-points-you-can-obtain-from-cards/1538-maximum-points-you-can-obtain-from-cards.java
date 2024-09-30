class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int lsum = 0;
        int rSum = 0;
        for(int i = 0; i <=k-1; i++){
            lsum = lsum + cardPoints[i];
        }
        maxSum = lsum;
        int rIndex = cardPoints.length-1;
        for(int i = k-1; i>=0; i--){
            lsum = lsum - cardPoints[i];
            rSum = rSum + cardPoints[rIndex];
            rIndex = rIndex-1;
            maxSum = Math.max(maxSum, lsum + rSum);
        }
        return maxSum;

    }
}