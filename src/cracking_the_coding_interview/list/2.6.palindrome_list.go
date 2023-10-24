package list

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}
	head2 := head
	var recursivelyCheck func(*ListNode) bool
	recursivelyCheck = func(node *ListNode) bool {
		if node != nil {
			if !recursivelyCheck(node.Next) {
				return false
			}
			if node.Val != head2.Val {
				return false
			}
			head2 = head2.Next
		}
		return true
	}
	return recursivelyCheck(head)
}
