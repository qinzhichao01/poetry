//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2311 👎 0


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

//struct ListNode
//{
//    int val;
//    ListNode *next;
//    ListNode() : val(0), next(nullptr) {}
//    ListNode(int x) : val(x), next(nullptr) {}
//    ListNode(int x, ListNode *next) : val(x), next(next) {}
//};
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head == nullptr)
        {
            return head;
        }

        ListNode *pHead = new ListNode();
        auto pTail = pHead;
        auto left = head;
        auto record = head;
        auto right = head->next;

        while (record)
        {
            left = record;
            right = record->next;
            if(right)
            {
                record = right->next;
            } else
            {
                record = nullptr;
            }

            left->next = nullptr;

            if(right)
            {
                right->next = left;
                pTail->next = right;
            } else {
                pTail->next = left;
            }
            pTail = left;
        }

        auto res = pHead->next;
        delete pHead;
        pHead = nullptr;
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
