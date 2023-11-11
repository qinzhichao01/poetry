package list

func getIntersectionNode(headA, headB *ListNode) *ListNode {

	nodeA := headA
	nodeB := headB
	for nodeA != nodeB {
		if nodeA == nil {
			nodeA = headB
		} else {
			nodeA = nodeA.Next
		}
		if nodeB == nil {
			nodeB = headA
		} else {
			nodeB = nodeB.Next
		}

	}
	return nodeA
}
