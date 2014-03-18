// Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int iLen = inorder.length;
        int pLen = postorder.length;
        if(iLen!=pLen||iLen==0){
        	return null;
        }

        return helper(inorder, postorder, 0, pLen-1, pLen-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int iStart, int iEnd, int pPos){
    	if(iStart>iEnd){
    		return null;
    	}
    	if(iStart==iEnd){
    		return new TreeNode(inorder[iEnd]);
    	}

    	int mid = 0;
    	for(int i = iStart; i<=iEnd; i++){
    		if(postorder[pPos]==inorder[i]){
    			mid = i;
    			break;
    		}
    	}
    	TreeNode root = new TreeNode(inorder[mid]);
    	root.left = helper(inorder, postorder, iStart, mid-1, pPos-(iEnd-mid+1));
    	root.right = helper(inorder, postorder, mid+1, iEnd, pPos-1);

    	return root;
    }
}