// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

public class Solution{
	public boolean isValidBST(TreeNode root){
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean helper(TreeNode node, int min, int max){
		if(node==null){
			return true;
		}

		if(node.val<=min||node.val>=max){
			return false;
		}else{
			return helper(node.left, min, node.val)&&helper(node.right, node.val, max);
		}
	}
}