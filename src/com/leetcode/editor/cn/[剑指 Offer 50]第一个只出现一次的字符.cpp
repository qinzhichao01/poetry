//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
//
// Related Topics 队列 哈希表 字符串 计数 👍 338 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <string>
#include <map>
class Solution {
public:
    char firstUniqChar(string s) {
        if (s.empty()) {
            return ' ';
        }

        std::map<char, int> mapSet;
        for (auto &val : s) {
            auto iter = mapSet.find(val);
            if (mapSet.end() == iter) {
                mapSet.insert(pair<char, int>(val, 1));
                continue;
            }
            iter->second += 1;
        }

        for (auto &val : s) {
            auto iter = mapSet.find(val);
            if (mapSet.end() != iter) {
                if (1 == iter->second) {
                    return val;
                }
            }
        }

        return ' ';
    }
};
//leetcode submit region end(Prohibit modification and deletion)
