//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4298 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int trap(vector<int> &height) {
        int size = height.size();
        if (3 > size) {
            return 0;
        }

        vector<int> leftMax(height);
        vector<int> rightMax(height);
        for (int i = 1; i < size; i++) {
            if (height[i] > leftMax[i - 1]) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = leftMax[i - 1];
            }

            if (height[size - i - 1] > rightMax[size - i]) {
                rightMax[size - i - 1] = height[size - i - 1];
            } else {
                rightMax[size - i - 1] = rightMax[size - i];
            }
        }
        /*for (auto &val : leftMax) {
            cout << val << " ";
        }
        cout << endl;
        for (auto &val : rightMax) {
            cout << val << " ";
        }*/
        int res = 0;
        for (int i = 1; i < size - 1; i++) {
            if (height[i] < leftMax[i - 1] && height[i] < rightMax[i + 1]) {
                res += (min(leftMax[i - 1], rightMax[i + 1]) - height[i]);
            }
        }

        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
