//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 7128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

#include <vector>
#include <algorithm>
#include <string>

bool mySort(int &a , int &b)
{
    return a < b;
}

using namespace std;

class Solution {
private:
    vector<vector<int>> res;
    string strRes = "";
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end(), mySort);
        int index = 0;

        while(index < (nums.size() - 2))
        {
            if(nums[index] > 0)
            {
                break;
            }

            if((index > 0) && (nums[index] == nums[index-1]))
            {
                index++;
                continue;
            }

            int left = index + 1, right = nums.size() -1;

            while (left < right)
            {
                auto sum = (nums[index] + nums[left] + nums[right]);
                if(0 == sum)
                {
                    vector<int> vecTemp(3,0);
                    vecTemp[0] = nums[index];
                    vecTemp[1] = nums[left];
                    vecTemp[2] = nums[right];
                    res.emplace_back(vecTemp);

                    while ((left < right) && (nums[left] == nums[++left]));
                    while ((left < right) && (nums[right] == nums[--right]));
                    continue;
                }

                if(sum < 0)
                {
                    while ((left < right) && (nums[left] == nums[++left]));
                } else
                {
                    while ((left < right) && (nums[right] == nums[--right]));
                }
            }

            index++;
        }
        //cout << endl << strRes << endl;

        return res;
    }


};
//leetcode submit region end(Prohibit modification and deletion)
