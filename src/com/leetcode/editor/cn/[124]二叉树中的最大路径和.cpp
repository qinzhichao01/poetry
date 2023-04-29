//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1930 👎 0


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
class Solution
{
private:
    int _res_max_sum = INT_MIN;

public:
    int maxPathSum(TreeNode *root)
    {
        getMax(root);
        return _res_max_sum;
    }
private:
    int getMax(TreeNode *root)
    {
        if (nullptr == root)
        {
            return 0;
        }

        // 左右两边的最大值只有在大于0的情况下才有意义
        int left_max = max(getMax(root->left), 0);
        int right_max = max(getMax(root->right), 0);
        int temp = left_max + right_max + root->val;
        _res_max_sum = max(_res_max_sum, temp);

        // 这儿因为题目中给出的是一路径中同一节点不能出现两次
        return root->val + max(left_max, right_max);
    }
};
//leetcode submit region end(Prohibit modification and deletion)
