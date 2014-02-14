public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root==null){
    		return result;
    	}
    	helper(result, root);
    	return result;
    }

    public void helper(ArrayList<Integer> result, TreeNode node){
    	if(node==null){
    		return;
    	}
    	helper(result,node.left);
    	helper(result, node.right);
    	result.add(node.val);
    }
}