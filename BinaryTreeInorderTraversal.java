// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?



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
	// Recursive solution.
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     if(root==null){
    //     	return result;
    //     }

    //     helper(result, root);

    //     return result;
    // }

    // public void helper(ArrayList<Integer> result, TreeNode node){
    // 	if(node==null){
    // 		return;
    // 	}

    // 	helper(result, node.left);
    // 	result.add(node.val);
    // 	helper(result, node.right);
    // }

    // Iterative solution
    public ArrayList<Integer> inorderTraversal(TreeNode root){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root==null){
    		return result;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode current = root;
    	while(!stack.isEmpty()||current!=null){
    		if(current!=null){
    			stack.push(current);
    			current = current.left;
    		}else{
    			current = stack.pop();
    			result.add(current.val);
    			current = current.right;
    		}
    	}
    	return result;
    }
}