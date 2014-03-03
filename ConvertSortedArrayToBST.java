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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0){
        //   TreeNode node = new TreeNode();
          return null;  
        } 
        
        TreeNode root =  helper(num, 0, num.length-1);
        return root;
    }
    
    public TreeNode helper(int[] num, int start, int end){
        if(start>end) return null;
        
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(num[mid]);
        
        node.left = helper(num,start,mid-1);
        node.right = helper(num, mid+1,end);
        
        return node;
    }
}