//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2664 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>
#include <stdlib.h>
using namespace std;
class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size() < 2)
        {
            return 0;
        }

        int count = 1;
        int index = 0;
        while (index < (nums.size() - 1))
        {
            if((nums[index] + index) >= (nums.size() - 1))
            {
                break;
            }

            int maxStep = INT_MIN;
            int i = 0;
            int maxIndex = index;
            for(i = index + 1; (i <= (index + nums[index])) && (i < nums.size()); i++)
            {
                auto sum = i + nums[i];
                if(maxStep < sum)
                {
                    maxIndex = i;
                    maxStep = sum;
                }
            }
            count++;
            index = maxIndex;
        }

        return count;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
