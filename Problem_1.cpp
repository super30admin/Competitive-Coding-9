// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Flatten Binary Tree to Linked List
// Approach: DFS
// Time Complexity: O(N)
// Space Complexity: O(N)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    public:
        void flatten(TreeNode* root) {
            if (root == nullptr) {
                return;
            }
            dfs(root);
        }
    
        TreeNode* dfs(TreeNode* root) {
            if (root == nullptr) {
                return nullptr;
            }
    
            cout << "Processing Node: " << root->val << endl;
    
            TreeNode* rightSubtree = root->right;
    
            TreeNode* leftTail = dfs(root->left);
            TreeNode* rightTail = dfs(root->right);
    
            if (leftTail) {
                leftTail->right = rightSubtree;
                root->right = root->left;
                root->left = nullptr;
            }
    
            return rightTail ? rightTail : (leftTail ? leftTail : root);
        }
    };