// Follow up for problem "Populating Next Right Pointers in Each Node".

// What if the given tree could be any binary tree? Would your previous solution still work?

// Note:

// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {


      // no extra space solution.
        if(root==null){
          return;
        }

        TreeLinkNode temp = root.next;

        while(temp!=null){
          if(temp.left!=null||temp.right!=null){
            temp = temp.left==null? temp.right : temp.left;
            break;
          }
          temp = temp.next;
        }

        if(root.left!=null){
          if(root.right!=null){
            root.left.next =root.right;
          }else{
              root.left.next = temp;
          }
        }
        if(root.right!=null){
          root.right.next = temp;
        }

        connect(root.right);
        connect(root.left);

      // //Level order solution.
    //     if(root==null){
    //       return;
    //     }
    //     ArrayList<ArrayList<TreeLinkNode>> levelNodes = new ArrayList<ArrayList<TreeLinkNode>>();
    //       ArrayList<TreeLinkNode> tempList = new ArrayList<TreeLinkNode>();
    //     levelNodes.add(tempList);
    //     helper(levelNodes, root, 1);

    //     for(ArrayList<TreeLinkNode> list : levelNodes){
    //       TreeLinkNode first = list.get(0);
    //       for(int i = 1; i<list.size();i++){
    //         TreeLinkNode current = list.get(i);
    //         first.next = current;
    //         first = current;
    //       }
    //     }
    // }

    //   public void helper(ArrayList<ArrayList<TreeLinkNode>> result, TreeLinkNode node, int level){
    //       if(node==null){
    //         return;
    //       }

    //       ArrayList<TreeLinkNode> tempList = new ArrayList<TreeLinkNode>();

    //       if(result.size()>=level){
    //         tempList = result.get(level-1);
    //       }else{
    //         result.add(tempList);
    //       }

    //       tempList.add(node);
    //       helper(result, node.left, level+1);
    //       helper(result, node.right, level+1);
        }
}