import java.util.*;
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        /* Brute force Approach */
        // int maxEle = 0;
        // int peek = 0;
        // for(int i=0; i<arr.length; i++){
        //     if(maxEle < arr[i]){
        //         maxEle = arr[i];
        //         peek = i;
        //     }
        // }
        // return peek;

        /* optimal  Approach(Binary Search) */
         int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid point
            
            // Check if we're in the increasing or decreasing part of the mountain
            if (arr[mid] < arr[mid + 1]) {
                // If mid is less than its next element, we're in the increasing part
                left = mid + 1;
            } else {
                // If mid is greater than or equal to its next element, we're in the decreasing part
                right = mid;
            }
        }

        // When left == right, we've found the peak index
        return left;
        
    }
}