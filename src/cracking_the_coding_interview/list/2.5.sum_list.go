package list

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

	var len1, len2 = 0, 0

	var node1, node2 = l1, l2

	for node1 != nil {
		len1++
		node1 = node1.Next
	}
	for node2 != nil {
		node2 = node2.Next
		len2++
	}
	if len2 > len1 {
		return addTwoNumbers(l2, l1)
	}
	var temp = 0
	var head = l1
	var pre = l1
	for l1 != nil {
		temp = l1.Val + temp
		if l2 != nil {
			temp = temp + l2.Val
			l2 = l2.Next
		}
		l1.Val = temp % 10
		temp = temp / 10
		pre = l1
		l1 = l1.Next
	}

	if temp > 0 {
		pre.Next = &ListNode{Val: temp}
	}

	return head
}
