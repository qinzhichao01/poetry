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
func isBalanced(root *TreeNode) bool {
	_, b := depth(root)
	return b
}

func depth(node *TreeNode) (int, bool) {
	if node == nil {
		return 0, true
	}
	leftLength, b := depth(node.Left)

	rightLength, b2 := depth(node.Right)

	if b && b2 {
		if math.Abs(float64(leftLength-rightLength)) > 1 {
			return 0, false
		}
		return int(math.Max(float64(leftLength), float64(rightLength)) + 1), true
	}

	return 0, false

}
