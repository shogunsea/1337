 // Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// Cheating approach, first do the level order traversal, 
// then reverse odd level lists.

// Not tested yet!
public class Solution{
	public ArrayList<ArrayList<Integer>> ZigzagOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null){
			return result;
		}

		ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();
		tempList.add(root);

		while(tempList.size()!=0){
			// result.add(tempList);
			ArrayList<TreeNode> current = new ArrayList<TreeNode>();
			ArrayList<Integer> valList = new ArrayList<Integer>();
			for(TreeNode t : tempList){
				valList.add(t.val);
				if(t.left!=null){
					current.add(t.left);
				}
				if(t.right!=null){
					current.add(t.right);
				}


			}
			tempList = current;
			result.add(valList);
		}

		return reorder(result);

	}

	public ArrayList<ArrayList<Integer>> reorder(ArrayList<ArrayList<Integer>> old){
		for(int i = 0; i<old.size(); i++){
			if(i%2!=0){

				ArrayList<Integer> tempList = old.get(i);
				Collecions.reverse(tempList);
			}
		}
		return old;
	}
}


// Tingshen's version.
public class Solution{
	public ArrayList<ArrayList<Integer>> ZigzagOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null){
			return	 result;
		}

		boolean reverse = false;
		int left = 1;
		int right = 0;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.addFirst/Last?~~
		while(!queue.isEmpty()){
			if(reverse){
				while(left!=0){
					//logic
					right++;
					left--;
				}

			}else{
				while(right!=0){
					//logic
					left++;
					right--;
					// blah blah
				}
			}
		}


	}
}