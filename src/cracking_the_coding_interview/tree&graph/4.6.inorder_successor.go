package tree_graph

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Val < p.Val {
		return inorderSuccessor(root.Right, p)
	}
	successor := inorderSuccessor(root.Left, p)
	if successor == nil {
		return root
	}
	return successor

}
