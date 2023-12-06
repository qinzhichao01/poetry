//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics 树 二叉搜索树 二叉树 👍 1280 👎 0


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
    TreeNode *deleteNode(TreeNode *root, int key) {
        if (nullptr == root) {
            return nullptr;
        }

        // 添加父结点
        TreeNode *pParent = new TreeNode;
        pParent->left = root;
        auto temp_parent = pParent;

        // 开始查找结点
        while (root != nullptr && key != root->val) {
            //cout << root->val << endl;
            temp_parent = root;
            if (key < root->val) {
                root = root->left;
                continue;
            }

            // key < root->val
            root = root->right;
        }

        if (root == nullptr) {
            auto res = pParent->left;
            delete pParent;
            pParent = nullptr;
            return res;
        }
        //cout << root->val << endl;

        // 有左右孩子，找到右子树的最小值
        if (root->left != nullptr && root->right != nullptr) {
            auto parent = root;
            auto right_min = root->right;
            //cout << right_min->val;
            while (right_min->left != nullptr) {
                parent = right_min;
                right_min = right_min->left;
            }

            root->val = right_min->val;
            bool is_left = (parent->left == right_min);

            // 若right_min有子树则其一定是右子树，否则没有子树
            if (right_min->right != nullptr) {
                if (is_left) {
                    parent->left = right_min->right;
                } else {
                    parent->right = right_min->right;
                }
            } else {
                // right无孩子
                if (is_left) {
                    parent->left = nullptr;
                } else {
                    parent->right = nullptr;
                }
            }
            delete right_min;
            right_min = nullptr;
        } else if (root->left != nullptr) {
            // 只有左子树
            bool is_left = (temp_parent->left == root);
            if (is_left) {
                temp_parent->left = root->left;
            } else {
                temp_parent->right = root->left;
            }
            delete root;
            root = nullptr;
        } else if (root->right != nullptr) {
            bool is_left = (temp_parent->left == root);
            if (is_left) {
                temp_parent->left = root->right;
            } else {
                temp_parent->right = root->right;
            }
            delete root;
            root = nullptr;
        } else {
            // 无左右孩子
            bool is_left = (temp_parent->left == root);
            if (is_left) {
                temp_parent->left = nullptr;
            } else {
                temp_parent->right = nullptr;
            }
            delete root;
            root = nullptr;
        }

        auto res = pParent->left;
        delete pParent;
        pParent = nullptr;
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
