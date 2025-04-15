import java.util.*;

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map values in nums2 to their indices for quick lookup
        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            indexMap[nums2[i]] = i;
        }

        // Transform nums1 to the indices of nums2
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = indexMap[nums1[i]];
        }

        long[] leftCount = new long[n];
        long[] rightCount = new long[n];

        FenwickTree leftTree = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            leftCount[i] = leftTree.query(transformed[i]);
            leftTree.update(transformed[i], 1);
        }

        FenwickTree rightTree = new FenwickTree(n);
        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = rightTree.query(n - 1) - rightTree.query(transformed[i]);
            rightTree.update(transformed[i], 1);
        }

        long goodTriplets = 0;
        for (int i = 0; i < n; i++) {
            goodTriplets += leftCount[i] * rightCount[i];
        }

        return goodTriplets;
    }

    static class FenwickTree {
        int[] bit;

        public FenwickTree(int size) {
            bit = new int[size + 1];
        }

        public void update(int index, int val) {
            index++;
            while (index < bit.length) {
                bit[index] += val;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}
