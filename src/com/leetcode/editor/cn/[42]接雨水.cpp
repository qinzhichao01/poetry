//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4298 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
public:
    int trap(vector<int> &height)
    {
        int size = height.size();
        if (2 > size)
        {
            return 0;
        }

        // 求左右两边的i最大值
        vector<int> left_max(height);
        vector<int> right_max(height);
        for (int i = 1; i < size; ++i)
        {
            left_max[i] = max(left_max[i - 1], left_max[i]);
            right_max[size - i - 1] = max(right_max[size - i - 1], right_max[size - i]);
        }

        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < size - 1; ++i)
        {
            left = left_max[i - 1];
            right = right_max[i + 1];
            if (min(left, right) <= height[i])
            {
                continue;
            }
            res += (min(left, right) - height[i]) > 0 ? (min(left, right) - height[i]) : 0;
        }

        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
