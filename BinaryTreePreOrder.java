// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

// Note: Recursive solution is trivial, could you do it iteratively?


public class Solution{
// Recursive solution.
    // public ArrayList<Integer> preorderTraversal(TreeNode node){
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     if(node==null){
    //         return result;
    //     }
        
    //     helper(result, node);
       
    //     return result;
    // }
    
    // public void helper(ArrayList<Integer> result, TreeNode node){
    //     if(node==null){
    //         return;
    //     }
        
    //     result.add(node.val);
    //     helper(result, node.left);
    //     helper(result, node.right);
    // }
    
    // Iterative solution
    public ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}