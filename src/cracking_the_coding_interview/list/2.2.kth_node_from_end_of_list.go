package list

func kthToLast(head *ListNode, k int) int {

	var node = head
	for i := 0; i < k; i++ {
		node = node.Next
	}
	for node != nil {
		head = head.Next
		node = node.Next
	}
	return head.Val

}
