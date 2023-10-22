package list

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
	var dumpy = &ListNode{}
	var head2 = dumpy
	dumpy2 := &ListNode{}
	var head3 = dumpy2
	for head != nil {
		next := head.Next
		head.Next = nil
		if head.Val < x {
			dumpy.Next = head
			dumpy = dumpy.Next
		} else {
			dumpy2.Next = head
			dumpy2 = dumpy2.Next
		}
		head = next
	}
	dumpy.Next = head3.Next
	return head2.Next
}

func partition2(head *ListNode, x int) *ListNode {
	var left = head
	var right = head
	for right != nil {
		if right.Val < x {
			swap(left, right)
			left = left.Next
		}
		right = right.Next
	}
	return head
}

func swap(left *ListNode, right *ListNode) {
	temp := right.Val
	right.Val = left.Val
	left.Val = temp
}
