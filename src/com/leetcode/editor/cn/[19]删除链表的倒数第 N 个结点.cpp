//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2969 👎 0


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
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head)
        {
            return head;
        }

        // 加一个头节点
        ListNode *Head = new ListNode;
        Head->next = head;

        auto pHead = Head;
        int sum = 0;
        while(pHead)
        {
            sum++;
            pHead = pHead->next;
            if(n == sum)
            {
                break;
            }
        }

        if(!pHead)
        {
            return nullptr;
        }

        if(sum != n)
        {
            return nullptr;
        }

        auto pCurrent = head;
        auto pBehind = Head;
        while(pHead->next)
        {
            pHead = pHead->next;
            pCurrent = pCurrent->next;
            pBehind = pBehind->next;
        }

        pBehind->next = pCurrent->next;
        delete pCurrent;
        pCurrent = nullptr;
        head = Head->next;
        delete Head;
        Head = nullptr;
        return head;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
