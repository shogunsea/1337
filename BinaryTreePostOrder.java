// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].

// Note: Recursive solution is trivial, could you do it iteratively?


// Recursive solution.
// public class Solution {
//     public ArrayList<Integer> postorderTraversal(TreeNode root) {
//     	ArrayList<Integer> result = new ArrayList<Integer>();
//     	if(root==null){
//     		return result;
//     	}
//     	helper(result, root);
//     	return result;
//     }

//     public void helper(ArrayList<Integer> result, TreeNode node){
//     	if(node==null){
//     		return;
//     	}
//     	helper(result,node.left);
//     	helper(result, node.right);
//     	result.add(node.val);
//     }
// }


// Iterative solution.
public class Solution {
    // public ArrayList<Integer> postorderTraversal(TreeNode root) {
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     if(root==null){
    //         return result;
    //     }
    //     TreeNode temp=root;
    //     Stack<TreeNode> stack=new Stack<TreeNode>();
    //     Stack<TreeNode> output=new Stack<TreeNode>();
    //     while(!stack.isEmpty()||temp!=null){
    //         if(temp!=null){
    //            output.push(temp);
    //            stack.push(temp);
    //            temp=temp.right;
    //         }else{
    //            temp=stack.pop();
    //            temp=temp.left;
    //         }
    //     }
    //     while(!output.isEmpty()){
    //         result.add(output.pop().val);
    //     }
    //     return result;
    // }
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                output.push(node);
                // result.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        while(!output.isEmpty()){
          result.add(output.pop().val);
        }
        return result;
    }
}