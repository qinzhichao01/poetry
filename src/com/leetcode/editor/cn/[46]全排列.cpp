//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3029 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        if(2 > nums.size())
        {
            res.push_back(nums);
            return res;
        }
        std::vector<int> temp;
        dfs(nums,temp,0);

        return res;
    }

    // 回溯算法
    void dfs(std::vector<int> & nums,std::vector<int> &temp, int idx)
    {
        if(idx >= nums.size())
        {
            res.push_back(temp);
            return;
        }


        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] != -11)
            {
                temp.push_back(nums[i]);
                auto currentVal = nums[i];
                nums[i] = -11;
                dfs(nums,temp,idx+1);
                nums[i] = currentVal;
                temp.pop_back();
            }
        }
    }

private:
    std::vector<std::vector<int>> res;
};
//leetcode submit region end(Prohibit modification and deletion)
