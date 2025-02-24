// TC: O(N)
// SC: O(1)
// where N is the number of nodes in the tree

public class LC114 {
    public void flatten(TreeNode root) {
        if(root==null) return;
        while(root!=null){
            if(root.left!=null){
                TreeNode right = root.right;
                TreeNode tail = root.left;
                while(tail.right!=null){
                    tail = tail.right;
                }
                root.right = root.left;
                tail.right = right;
                root.left = null;
            }
            root = root.right;
        }
    }
}