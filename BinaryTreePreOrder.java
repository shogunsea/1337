public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
        	return	result;
        }
        helper(result, root);
        return result;
    }

    public void helper(ArrayList<Integer> result, TreeNode node){
    	if(node==null){
    		return;
    	}
    	result.add(node.val);
    	helper(result, node.right);
    	helper(result, node.left);
    }
}