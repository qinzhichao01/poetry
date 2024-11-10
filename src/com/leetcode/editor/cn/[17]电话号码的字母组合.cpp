//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2944 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution {
    map<char ,vector<char>> m_map
            {
                    {'2', {'a', 'b', 'c'}},
                    {'3', {'d', 'e', 'f'}},
                    {'4', {'g', 'h', 'i'}},
                    {'5', {'j', 'k', 'l'}},
                    {'6', {'m', 'n', 'o'}},
                    {'7', {'p', 'q', 'r', 's'}},
                    {'8', {'t', 'u', 'v'}},
                    {'9', {'w', 'x', 'y', 'z'}}
            };
public:
    vector<string> letterCombinations(string digits) {
        if(digits.size() < 1)
        {
            return vector<string> ();
        }

        //sort(digits.begin(),digits.end(),[](char &a, char &b){return a < b;});

        vector<string > res;
        vector<string > temp;
        for(auto &val : m_map[digits[0]])
        {
            string strTemp = "";
            strTemp.push_back(val);
            temp.emplace_back(strTemp);
        }

        for(int i= 1; i < digits.size(); i++)
        {
                for(auto const & val : temp)
                {
                    for(int j = 0; j < m_map[digits[i]].size(); j++) {
                        string strTemp = val + m_map[digits[i]][j];
                        //sort(strTemp.begin(),strTemp.end(),[](char &a, char &b){return a < b;});
                        res.emplace_back(strTemp);
                    }
                }

            temp.clear();
            temp.assign(res.begin(),res.end());
            res.clear();
        }

        res.clear();
        res.assign(temp.begin(),temp.end());

        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
