//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1030 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>
class Solution {
public:
    int reversePairs(vector<int> &nums) {
        // 遍历,超时
        /*int res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                if (nums[i] > nums[j]) {
                    ++res;
                }
            }
        }*/

        count = 0;
        mergeSort(nums, 0, nums.size() - 1);

        return count;
    }

private:
    int count;

private:
    // 合并数组
    void merge(std::vector<int> &vec, int left, int mid, int right) {
        if (left >= right) {
            return;
        }

        std::vector<int> temp(right - left + 1, 0);
        int lleft = left;
        int rright = mid + 1;

        // 合并数组
        int index = 0;
        while (lleft <= mid && rright <= right) {
            if (vec[lleft] <= vec[rright]) {
                temp[index] = vec[lleft];
                ++lleft;
                count += (rright - mid - 1);
            } else {
                temp[index] = vec[rright];
                ++rright;
            }
            ++index;
        }

        while (lleft <= mid) {
            temp[index] = vec[lleft];
            ++lleft;
            ++index;
            count += (rright - mid - 1);
        }

        while (rright <= right) {
            temp[index] = vec[rright];
            ++rright;
            ++index;
        }

        index = left;
        for (auto &val : temp) {
            vec[index] = val;
            ++index;
        }
    }

    void mergeSort(std::vector<int> &vec, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(vec, left, mid);
            mergeSort(vec, mid + 1, right);
            merge(vec, left, mid, right);
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
