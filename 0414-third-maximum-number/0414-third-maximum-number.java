import java.util.*;
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

    // Add the elements to the TreeSet for uniqueness and Sorting
        for(int num: nums){
            set.add(num);
            // Keep onlhy the top 3 largest element
           if(set.size() > 3){
            set.pollFirst(); // Remove the smallest element
           }
        } 


        if(set.size() < 3){
            return set.last();
        }
       
       return set.first(); 
       
    }
}