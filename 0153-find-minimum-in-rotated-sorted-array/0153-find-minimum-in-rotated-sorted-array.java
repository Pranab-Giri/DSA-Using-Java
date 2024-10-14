class Solution {
    public int findMin(int[] arr) {
       int low = 0;
         int high = arr.length-1;
         // If the array is not rotated at all
        if (arr[low] <= arr[high]) {
            return arr[low];
        }
         while(low <= high){
             int mid = ( low + high )/2;
             // Check if mid element is the minimum
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            
            // Check if mid+1 is the minimum
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
             if(arr[mid] >= arr[low]){
                 low = mid+1;
             }else{
                 high = mid-1;
             }
         }
         return -1;
    }
}