//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 570 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <vector>
class Solution {
public:
    vector<int> getLeastNumbers(vector<int> &arr, int k) {
        std::vector<int> res;
        if (0 == k) {
            return res;
        }
        std::vector<int> temp(10001, 0);
        for (auto &val : arr) {
            ++temp[val];
        }

        int index = 0;
        int count = 0;
        for (auto &val : temp) {
            while (val) {
                res.emplace_back(index);
                ++count;
                --val;
                if (k == count) {
                    return res;
                }
            }
            ++index;
        }

        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
