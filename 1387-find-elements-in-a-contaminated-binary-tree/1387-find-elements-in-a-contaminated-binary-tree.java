/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class FindElements {
    private HashSet<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        recoverTree(root, 0);  // Start recovering from root with value 0
    }

    private void recoverTree(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;  // Assign correct value
        values.add(val);  // Store value in HashSet

        // Recur for left and right children
        recoverTree(node.left, 2 * val + 1);
        recoverTree(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);  // O(1) lookup
    }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */