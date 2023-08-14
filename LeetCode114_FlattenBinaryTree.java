//recursion based approach
//tc - O(N), sc - O(h)

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
class Solution {
    public void flatten(TreeNode root) {
       
        if(root == null) return;
        
        //we assign the left tree to one variable and righttree to another variable for recursive flatteing
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        
        //this will help to remove the left link. 
        root.left = null;
        
        //recursive call on left tree
        flatten(leftTree);
        //once we are done flattening the left, we do it with right;
        //System.out.println("\n ***right tree****");       
        flatten(rightTree);
        
        //we reach here when both of the tree for curr root are flatten and we are standing at the leaf curr!
        root.right =leftTree; //which is root.left
        
        //here root is th mn node, not the child, so, we'll store it and traverse till null.
         TreeNode curr = root;
        //we are at the end of the flattened left binary tree whose end is null and we want it to attch it to right subtree. 
        while(curr.right != null) curr = curr.right;
        
        //curr is pointing at last node, and merge to the temp right tree
        curr.right = rightTree;
        
        return;
    }  
}
    



//same as above, but efficient in terms of generating calls!
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
class Solution {
    public void flatten(TreeNode root) {
     
        if(root == null) return;
        
        TreeNode L = root.left;
        TreeNode R = root.right;
        root.left = null;
        
        if(L == null && R ==  null) return;
        
        if(L != null)
        {
            flatten(L);
            root.right = L;
            TreeNode curr = root;
            while(curr.right != null)
                curr = curr.right;
            curr.right = R;
        }
        flatten(R);
    }
}

//morris traversal
//tc - O(N), sc - O(1)

//moris traversal - TC O(N), SC - O(1)
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
class Solution {
    public void flatten(TreeNode root) {
     
        if(root == null) return;
        
        while(root != null)
        {
            TreeNode curr = root;
            
            if(curr.left != null)
            {
                curr = curr.left;
                while(curr.right != null)
                    curr = curr.right;
                curr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}