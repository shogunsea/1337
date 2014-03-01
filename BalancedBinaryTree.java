// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        	if(helper(root)==-1){
        		return false;
        	}
        	return true;
    }

    public int helper(TreeNode node){
    	if(node==null){
    		return 0;
    	}
    	int left = helper(node.left);
    	if(left==-1){
    		return -1;
    	}
    	int right = helper(node.right);
    	if(right ==-1){
    		return -1;
    	}

    	int differ = Math.abs(right-left);
    	if(differ>1){
    		return -1;
    	}
    	else{
    		return Math.max(left, right)+1;
    	}
    }
}