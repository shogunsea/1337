// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \      \
//         7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.



// Recursive solution.
// public class Solution{
//     public boolean hasPathSum(TreeNode root, int sum){
//        if(root==null){
//            return false;
//        }
//        if(root.left==null&&root.right==null){
//            return sum==root.val;
//        }
       
//        boolean leftSum = hasPathSum(root.left, sum-root.val);
//        boolean rightSum = hasPathSum(root.right, sum-root.val);
       
//        return leftSum || rightSum;
          
//     }
// }

// Iterative solution.
public class Solution{
    public boolean hasPathSum(TreeNode root, int sum){
        if(root==null){
            return false;
        }
        
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> sums = new LinkedList<Integer>();
         nodes.add(root);
         sums.add(root.val);
         while(!nodes.isEmpty()){
             TreeNode n = nodes.poll();
             int s = sums.poll();
             if(n.left==null&&n.right==null&&s==sum){
                 return true;
             }
             
             if(n.left!=null){
                 nodes.add(n.left);
                 sums.add(s+n.left.val);
             }
             
             if(n.right!=null){
                 nodes.add(n.right);
                 sums.add(s+n.right.val);
             }        
         }
         return false;
         }
 }
      