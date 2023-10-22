package list

/*
*
思路，删除中间 node
算出长度，然后再删除中间长度，时间复杂度为o(n)
那我使用快慢指针,阁下如何应对
*/
func deleteNode(node *ListNode) {
	node.Val = node.Next.Val
	node.Next = node.Next.Next
}
