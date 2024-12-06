class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int noOfElements = 0;
        int tempSum = 0;
        Set<Integer> number = new HashSet<>();
        for(int num : banned){
            number.add(num);
        }

        for(int i=1; i<=n; i++){
            if(!number.contains(i)){
                if(tempSum + i > maxSum){
                  break;
                }
                tempSum += i;
                noOfElements++;
            }
        }

        return noOfElements++;
       
    }
}