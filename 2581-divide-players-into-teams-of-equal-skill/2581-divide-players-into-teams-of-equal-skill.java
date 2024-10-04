import java.util.*;
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0;
        int left = 0;
        int right = skill.length-1;
        int temp = skill[left] + skill[right];
         
        while(left < right){
            if(temp == skill[left] + skill[right]){
                sum += skill[left] * skill[right];
                left++;
                right--;
            }else{
                return -1;
            }

        }
        return sum;
    }
}