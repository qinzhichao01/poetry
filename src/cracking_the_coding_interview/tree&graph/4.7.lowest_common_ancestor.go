package tree_graph

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	// root 等于 p q 任意一个
	if root.Val == p.Val || root.Val == q.Val {
		return root
	}
	// 因为 p q 不会重复，故而 left 和 right 如果不为空，只能是 right 和 left 为 p,q 父亲节点的一个
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	// 如果都不为空那么就是父亲节点
	if left != nil && right != nil {
		return root
	}
	// 同时因为不可能重复，如果left 或 right 为空，只能是在 p、q的父亲节点上方或在其中一个节点上面
	if left == nil {
		return right
	}
	return left
}
