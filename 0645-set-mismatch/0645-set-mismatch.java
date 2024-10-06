class Solution {
    public int[] findErrorNums(int[] nums) {
        int result[] = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                result[0] = num;
            }else{
                  set.add(num);
            }
        }
      int n = set.size();
      int totalSum = (n+1)*(n+2)/2;
      for(int num : set){
        totalSum -= num;
      } 
      result[1] = totalSum;
      return result;       
    }
}