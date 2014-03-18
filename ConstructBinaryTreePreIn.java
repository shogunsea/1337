// Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pLen = preorder.length;
        int iLen = inorder.length;
        if(pLen!=iLen||iLen==0){
            return null;
        }

        return helper(preorder, inorder, 0, pLen-1, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int iStart, int iEnd, int pPos){
        if(iStart>iEnd){
            return null;
        }
        if(iStart==iEnd){
            return new TreeNode(inorder[iEnd]);
        }

        int mid = 0;
        for(int i = iStart; i<=iEnd; i++){
            if(preorder[pPos]==inorder[i]){
                mid=i;
                break;
            }
        }

        TreeNode root = new TreeNode(inorder[mid]);
        root.left = helper(preorder, inorder, iStart, mid-1, pPos+1);
        root.right = helper(preorder, inorder, mid+1, iEnd, pPos+mid-iStart+1);

        return root;
    }



    // Iterative solution.
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    // 	int pLen = preorder.length;
    //     int iLen = inorder.length;
    //     if(pLen!=iLen||iLen==0){
    //     	return null;
    //     }
    //     Stack<Integer> st = new Stack<Integer>();
    //     st.push(preorder[0]);
    //     TreeNode root = new TreeNode(preorder[0]);
        
    //     while(!st.isEmpty()){
    //     	int current = st.pop();


    //     }

    // }
}