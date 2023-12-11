//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 530 👎 0


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
class Solution {
public:
    int getMinimumDifference(TreeNode *root) {
        if (nullptr == root) {
            return 0;
        }
        allNode(root);
        return m_nRes;
    }

    void allNode(TreeNode *ptr) {
        if (nullptr == ptr) {
            return;
        }
        // 找到当前节点的左子树的最右节点，右子树的最左节点
        auto left = ptr->left;
        while (left && left->right) {
            left = left->right;
        }

        // left为nullptr m_nRes = 0;
        if (nullptr != left) {
            int temp = abs(ptr->val - left->val);
            m_nRes = m_nRes > temp ? temp : m_nRes;
        }

        auto right = ptr->right;
        while (right && right->left) {
            right = right->left;
        }

        // left为nullptr m_nRes = 0;
        if (nullptr != right) {
            int temp = abs(ptr->val - right->val);
            m_nRes = m_nRes > temp ? temp : m_nRes;
        }

        allNode(ptr->left);
        allNode(ptr->right);
    }
private:
    int m_nRes = INT_MAX;
};
//leetcode submit region end(Prohibit modification and deletion)
