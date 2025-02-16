//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1679 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        std::vector<int> temp;
        dfs(nums,temp,0);
        return res;
    }

    // 回溯算法 vec:原始数组 temp:存储结果的 idx:多少层
    void dfs(std::vector<int>& vec, std::vector<int> &temp,int idx)
    {
        if(idx >= vec.size())
        {
            res.push_back(temp);
            return;
        }

        // 当前层次的选中的，采用位图的形式
        int currentSelect = 0;

        for(int i = 0; i < vec.size(); i++)
        {
            if(vec[i] != 11)
            {
                auto index = vec[i] < 0 ? (vec[i] + 21) : vec[i];
                if(0 == (currentSelect & (1 << index)))
                {
                    // 表示当前列没有被选中过
                    currentSelect = currentSelect | (1 << index);

                    // 选中当前位
                    temp.push_back(vec[i]);
                    auto tempVal = vec[i];
                    vec[i] = 11;
                    dfs(vec,temp,idx+1);
                    temp.pop_back();
                    vec[i] = tempVal;
                }
            }
        }
    }

private:
    std::vector<std::vector<int>> res;
};
//leetcode submit region end(Prohibit modification and deletion)
