//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1889 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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

#include <vector>
#include <stack>
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        /*treeSort(root);
        return m_vecResult;*/

        if(nullptr == root)
        {
            return m_vecResult;
        }

        // 采用栈的方法
        std::stack<TreeNode*> stackTree;
        while (!stackTree.empty() || root) {
            while(root)
            {
                stackTree.push(root);
                root = root->left;
            }

            root = stackTree.top();
            stackTree.pop();
            m_vecResult.emplace_back(root->val);
            root = root->right;
        }

        return m_vecResult;
    }

    void treeSort(TreeNode *root) {
        if (nullptr == root) {
            return;
        }
        treeSort(root->left);
        m_vecResult.emplace_back(root->val);
        treeSort(root->right);
    }
private:
    std::vector<int> m_vecResult;
};
//leetcode submit region end(Prohibit modification and deletion)
