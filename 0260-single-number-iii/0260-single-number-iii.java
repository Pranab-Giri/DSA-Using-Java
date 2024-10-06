import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int i=0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                result[i] = key;
                i++;
            }
        }
        return result;
    }
}