package tree_graph

import "math"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
	return isValidBst2(root, math.MinInt, math.MaxInt)
}

func isValidBst2(root *TreeNode, min, max int) bool {

	if root == nil {
		return true
	}
	if root.Val <= min || root.Val >= max {
		return false
	}
	if root.Left != nil && root.Left.Val >= root.Val {
		return false
	}
	if root.Right != nil && root.Right.Val <= root.Val {
		return false
	}
	return isValidBst2(root.Left, min, root.Val) && isValidBst2(root.Right, root.Val, max)
}
