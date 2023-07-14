//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2044 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

/*struct ListNode {
  int val;

  ListNode *next;

  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};*/
#include <vector>

class Solution {
public:
    ListNode *sortList(ListNode *head) {
        if (nullptr == head || nullptr == head->next) {
            return head;
        }

        std::vector<ListNode> vec;
        auto p = head;
        while (p) {
            vec.emplace_back(*p);
            p = p->next;
        }
        mergeSort(vec, 0, vec.size() - 1);
        p = head;
        for (auto &val : vec) {
            p->val = val.val;
            p = p->next;
        }
        return head;
    }

    // 归并排序
    void merge(std::vector<ListNode> &vec, int left, int mid, int right) {
        if (left > right) {
            return;
        }
        if (left > mid || right < mid) {
            return;
        }
        std::vector<ListNode> temp(right - left + 1);
        int lleft = left;
        int rright = mid + 1;
        int index = 0;

        while (lleft <= mid && rright <= right) {
            if (vec[rright].val < vec[lleft].val) {
                temp[index].val = vec[rright].val;
                ++rright;
            } else {
                temp[index].val = vec[lleft].val;
                ++lleft;
            }
            ++index;
        }

        while (lleft <= mid) {
            temp[index].val = vec[lleft].val;
            ++lleft;
            ++index;
        }

        while (rright <= right) {
            temp[index].val = vec[rright].val;
            ++rright;
            ++index;
        }

        index = left;
        for (auto &val : temp) {
            vec[index].val = val.val;
            ++index;
        }

    }

    void mergeSort(std::vector<ListNode> &vec, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(vec, left, mid);
            mergeSort(vec, mid + 1, right);
            merge(vec, left, mid, right);
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
