// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?	

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// recursive solution. 
public class Solution {
	TreeNode[] nodes = new TreeNode[3];
    public void recoverTree(TreeNode root) {
    	if(root==null){
    		return;
    	}
 		TreeNode s1=null, s2=null, pre=null;
 		nodes[0] = s1;
 		nodes[1] = s2;	
 		nodes[2] = pre;
 		traverse(root, nodes);
 		int temp = nodes[0].val;
 		nodes[0].val  = nodes[1].val;
 		nodes[1].val = temp;
 	}

 	public void	traverse(TreeNode node, TreeNode[] nodes){
 		if(node==null){
 			return;
 		}
 		traverse(node.left, nodes);

 		TreeNode pre = nodes[2];
 		TreeNode s1 = nodes[0];
 		TreeNode s2 = nodes[1];


 		if(pre!=null&&pre.val>node.val){
 			if(s1==null){
 				nodes[0] = pre;
 				nodes[1] = node;
 			}else{
 				nodes[1] = node;
 			}
 		}
 		nodes[2] = node;
 		traverse(node.right, nodes);
 	}
}

// iterative solution.
// public void recoverTree(TreeNode root) {
//     	    if(root==null){
//             	return;
//             }
//             Stack<TreeNode> stack = new Stack<TreeNode>();
//             TreeNode current = root, s1 = null, s2= null, pre=null;
        
//             while(!stack.isEmpty()||current!=null){
//             	if(current!=null){
//             		stack.push(current);
//             		current = current.left;
//             	}else{
//             		current = stack.pop();
//                     if(pre!=null&&pre.val>current.val){
//                         if(s1==null){
//                             s1 = pre;
//                             s2 = current;
//                         }else{
//                             s2 = current;
//                         }
//                     }
//                     pre = current;
//             		current = current.right;
//             	}
//             }
//             int temp = s1.val;
//             s1.val = s2.val;
//             s2.val = temp;
//     }