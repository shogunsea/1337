// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
        int len = 0;
        ListNode runner	= head;
        while(runner!=null){
        	len++;
        	runner = runner.next;
        }
        // Why use array here: mock the behaviour of a pointe, so that recursion calls modify same object.
        ListNode[] h = {head};
        return helper( h, 0, len-1);
    }

    public TreeNode helper(ListNode[] list, int start, int end){
    	if(start>end){
    		return null;
    	}
    	int mid = start + ((end-start)>>1);
    	TreeNode left = helper(list, start, mid-1);
    	TreeNode parent = new TreeNode(list[0].val);
    	parent.left = left;
    	list[0] = list[0].next;
    	TreeNode right = helper(list,mid+1, end);
    	parent.right = right;
    	return parent;
    }
}