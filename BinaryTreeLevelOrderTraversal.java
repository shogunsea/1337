// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null) return result;

		ArrayList<Integer> tempList = new ArrayList<Integer>();

		result.add(tempList);

		helper(result, root, 1);

		return result;
	}

	public void helper(ArrayList<ArrayList<Integer>> result, TreeNode node, int level){
		if(node==null) return;

		ArrayList<Integer> tempList;

		if(result.size()>=level){
			tempList = result.get(level-1);
		}else{
			tempList = new ArrayList<Integer>();
			result.add(tempList);
		}

		tempList.add(node.val);

		helper(result, node.left, level+1);
		helper(result, node.right, level+1);

	}
}