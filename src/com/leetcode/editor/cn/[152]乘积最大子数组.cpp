//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2007 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
public:
    int maxProduct(vector<int> &nums)
    {
        int size = nums.size();
        if (0 == size)
        {
            return 0;
        }
        int res = INT_MIN;
        vector<int> MaxProduct(nums);
        vector<int> MinProduct(nums);
        res = MaxProduct[0] > MinProduct[0] ? MaxProduct[0] : MinProduct[0];
        for (int i = 1; i < size; ++i)
        {
            MaxProduct[i] = max(max(MaxProduct[i - 1] * nums[i], MinProduct[i - 1] * nums[i]), nums[i]);
            MinProduct[i] = min(min(MaxProduct[i - 1] * nums[i], MinProduct[i - 1] * nums[i]), nums[i]);
            res = res > max(MaxProduct[i], MinProduct[i]) ? res : max(MaxProduct[i], MinProduct[i]);
        }
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
