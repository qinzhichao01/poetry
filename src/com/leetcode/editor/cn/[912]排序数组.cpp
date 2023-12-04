//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 862 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>

using namespace std;
class Solution {
public:
    vector<int> sortArray(vector<int> &nums) {
        // 冒泡排序, 超时
        /*for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums.size() - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    nums[j + 1] += nums[j];
                    nums[j] = nums[j + 1] - nums[j];
                    nums[j + 1] -= nums[j];
                }
            }
        }
        return nums;*/

        // 分治方法-快速排序方法，超时
        //quickSort(nums, 0, nums.size() - 1);

        // 归并排序,通过
        /*
         * 执行耗时:512 ms,击败了13.68% 的C++用户
         * 内存消耗:141.2 MB,击败了7.72% 的C++用户
         */
        mergeSort(nums, 0, nums.size() - 1);
        return nums;
    }

    // 归并排序
    void merge(vector<int> &vec, int left, int mid, int right) {
        if (left > right) {
            return;
        }

        if (left > mid || right < mid) {
            return;
        }

        vector<int> temp(right - left + 1, 0);
        int lleft = left;
        int rright = mid + 1;
        int index = 0;
        while (lleft <= mid && rright <= right) {
            if (vec[lleft] < vec[rright]) {
                temp[index] = vec[lleft];
                ++lleft;
            } else {
                temp[index] = vec[rright];
                ++rright;
            }
            index++;
        }

        while (lleft <= mid) {
            temp[index] = vec[lleft];
            ++lleft;
            ++index;
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

    void mergeSort(vector<int> &vec, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(vec, left, mid);
            mergeSort(vec, mid + 1, right);
            merge(vec, left, mid, right);
        }
    }
    void quickSort(vector<int> &nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 选取第一个作为参考目标
        int target = nums[left];
        int lleft = left;
        int rright = right;
        int mid = (rright + lleft) / 2;
        while (lleft < rright) {
            while (rright > lleft && nums[rright] >= target) {
                --rright;
            }

            while (lleft < rright && nums[lleft] <= target) {
                ++lleft;
            }

            if (lleft < rright) {
                swap(nums[lleft], nums[rright]);
            }
        }

        if (lleft <= rright) {
            swap(nums[left], nums[lleft]);
        }
        quickSort(nums, left, lleft - 1);
        quickSort(nums, lleft + 1, right);
    }
};
//leetcode submit region end(Prohibit modification and deletion)
