import java.util.*;
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int maxEle = 0;
        int peek = 0;
        for(int i=0; i<arr.length; i++){
            if(maxEle < arr[i]){
                maxEle = arr[i];
                peek = i;
            }
        }
        return peek;
        
    }
}