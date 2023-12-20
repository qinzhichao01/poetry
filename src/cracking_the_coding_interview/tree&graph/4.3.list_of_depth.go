package tree_graph

import "container/list"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func listOfDepth(tree *TreeNode) []*ListNode {
	var res []*ListNode
	if tree == nil {
		return res
	}

	l := list.New()
	l.PushBack(tree)
	for l.Len() > 0 {
		length := l.Len()
		dumpy := new(ListNode)
		head := dumpy
		for length > 0 {
			element := l.Front()
			l.Remove(element)
			node := element.Value.(*TreeNode)
			listNode := &ListNode{Val: node.Val}
			head.Next = listNode
			head = head.Next
			if node.Left != nil {
				l.PushBack(node.Left)
			}
			if node.Right != nil {
				l.PushBack(node.Right)
			}
			length--
		}
		res = append(res, dumpy.Next)
	}
	return res
}
