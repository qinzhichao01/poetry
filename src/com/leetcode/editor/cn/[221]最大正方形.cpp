//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1440 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
public:
    int maximalSquare(vector<vector<char>> &matrix)
    {
        int row = matrix.size();
        if (row == 0)
        {
            return 0;
        }
        int col = matrix[0].size();
        vector<vector<int>> temp(row, vector<int>(col, 0));
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                temp[i][j] = matrix[i][j] - '0';
            }
        }


        // 采用动态规划
        vector<vector<int>> dp(temp);
        // for (auto &val : matrix)
        // {
        //     dp.emplace_back(val);
        // }

        int sq = 0;
        for (int i = 1; i < row; ++i)
        {
            for (int j = 1; j < col; ++j)
            {
                if (temp[i][j] == 0)
                {
                    continue;
                }

                if (temp[i][j - 1] == 0 || temp[i - 1][j] == 0)
                {
                    continue;
                }

                sq = sqrt(min((dp[i][j - 1]), (dp[i - 1][j])));
                int tmp = 1;
                while (sq > 0)
                {
                    // 验证对角
                    if (temp[i - sq][j - sq] != 0)
                    {
                        tmp = (sq + 1) * (sq + 1);
                        dp[i][j] = dp[i][j] > tmp ? dp[i][j] : tmp;
                    }
                    --sq;
                }
            }
        }

        // 找最大值
        int res = INT_MIN;
        for (auto &val : dp)
        {
            res = max(res, *max_element(val.begin(), val.end()));
        }

        // for (auto &val : dp)
        // {
        //     for (auto &v : val)
        //     {
        //         cout << v << " ";
        //     }
        //     cout << endl;
        // }

        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
