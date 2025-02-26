/*
TC : O(N)
SC : O(H)
*/
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
class Solution
{
public:
    void flatten(TreeNode *root)
    {
        if (root == nullptr)
        {
            return;
        }

        stack<TreeNode *> st;
        TreeNode *curr;

        st.push(root);
        while (!st.empty())
        {
            curr = st.top();
            st.pop();
            if (curr->right != nullptr)
            {
                st.push(curr->right);
            }

            if (curr->left != nullptr)
            {
                st.push(curr->left);
            }

            curr->left = nullptr;
            if (!st.empty())
            {
                curr->right = st.top();
            }
        }
    }
};