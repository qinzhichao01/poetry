package list

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeDuplicateNodes(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	dummy := new(ListNode)
	dummy.Next = head
	mapSet := make(map[int]bool)
	mapSet[head.Val] = true

	for head.Next != nil {

		next := head.Next
		if _, ok := mapSet[next.Val]; ok {
			head.Next = next.Next
			continue
		}
		head = head.Next
		mapSet[head.Val] = true

	}
	return dummy.Next
}
