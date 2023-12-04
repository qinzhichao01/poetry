//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
//
// Related Topics 位运算 数组 双指针 二分查找 👍 2183 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>
#include <memory>
class Solution {
public:
    int findDuplicate(vector<int> &nums) {
        // 位图的方式
        int size = nums.size();

        if (size < 3) {
            return nums[0];
        }

        std::vector<int> bitMap(size / 32 + 32, 0);
        for (auto &val : nums) {
            if (haveSetBitPos(bitMap, val)) {
                return val;
            }
            setBitPos(bitMap, val);
        }

        return 0;
    }

    void setBitPos(std::vector<int> &vec, int index) {
        vec[index / 32] |= (1 << (index % 32));
        //cout << (index / 32) << " " << (index % 32);
    }

    bool haveSetBitPos(std::vector<int> &vec, int index) {
        //cout << (index / 32) << " " << (index % 32) << " " << (vec[index / 32] >> (index % 32));
        return (0x1) & (vec[index / 32] >> (index % 32));
    }
};
//leetcode submit region end(Prohibit modification and deletion)
