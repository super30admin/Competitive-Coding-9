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
//Time: O(n)
//Space: O(1)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        TreeNode node = root;
        
        while(node != null){
            if(node.left != null){
                TreeNode rightchild = node.left;
                while(rightchild.right != null){
                    rightchild = rightchild.right;
                }
                rightchild.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
