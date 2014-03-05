// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]


public class Solution {
   public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(root==null){
	        	return result;
	        }
	        ArrayList<Integer> tempList = new ArrayList<Integer>();
        	helper(root,sum,0,tempList,result);
	        return result;
	    }
    public void helper(TreeNode node, int sum, int tempSum, ArrayList<Integer> tempList, ArrayList<ArrayList<Integer>> result){
    	if(node==null){
    		return;
    	}

    	tempList.add(node.val);
    	tempSum += node.val;
    	if( tempSum ==sum && node.left==null&&node.right == null){
    		result.add(new ArrayList<Integer>(tempList));
    	}

    	helper(node.left, sum, tempSum, tempList, result);
    	helper(node.right, sum, tempSum, tempList, result);

    	tempList.remove(tempList.size()-1);
    }
}