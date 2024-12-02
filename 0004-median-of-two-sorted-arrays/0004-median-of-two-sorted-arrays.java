class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         // Merge the two sorted arrays
        int[] mergedArray = mergeArrays(nums1, nums2);
        
        // Find the median of the merged array
        int n = mergedArray.length;
        if (n % 2 == 1) {
            return mergedArray[n / 2];
        } else {
            return (mergedArray[n / 2 - 1] + mergedArray[n / 2]) / 2.0;
        }
    }
      // Merge two sorted arrays
    public static int[] mergeArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] merged = new int[n1 + n2];
        
        int i = 0, j = 0, k = 0;
        
        // Merge the arrays
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        // Add remaining elements from nums1
        while (i < n1) {
            merged[k++] = nums1[i++];
        }
        
        // Add remaining elements from nums2
        while (j < n2) {
            merged[k++] = nums2[j++];
        }
        
        return merged;
    }
}