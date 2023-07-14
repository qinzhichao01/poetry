//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2214 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>

class Solution {
public:
    int findKthLargest(vector<int> &nums, int k) {
        int size = nums.size();
        for (int i = size / 2 - 1; i >= 0; --i) {
            heapMain(nums, size, i);
        }

        while (k--) {
            std::swap(nums[0], nums[size - 1]);
            if (0 == k) {
                return nums[size - 1];
            }
            --size;
            heapMain(nums, size, 0);
        }

        return 0;
    }

    // 堆排序 堆维护
    void heapMain(std::vector<int> &vec, int size, int index) {
        int left = 2 * index + 1;
        int right = left + 1;
        int maxIndex = index;
        if (left < size && vec[left] > vec[maxIndex]) {
            maxIndex = left;
        }

        if (right < size && vec[right] > vec[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != index) {
            std::swap(vec[index], vec[maxIndex]);
            heapMain(vec, size, maxIndex);
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
