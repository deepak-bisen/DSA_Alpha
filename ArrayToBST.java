//que. 108 topic array
//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

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
class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
       return helper(nums, 0, nums.length-1) ;
    }
    TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null; // Base case: empty subarray
        }

        int mid = left + (right - left) / 2; // Avoids overflow
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }

}
