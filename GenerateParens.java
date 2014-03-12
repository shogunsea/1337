// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"
public class Solution{
	public static ArrayList<String> generateParenthesis(int count) {
		ArrayList<String> result = new ArrayList<String>();
		if(count<1){
			return result;
		}
		StringBuilder sb = new StringBuilder();

		helper(result, count, count, sb);

		return result;
	}

	public static void helper(ArrayList<String> result, int left, int right, StringBuilder sb){
		if(left==0&&right==0){
			String s = sb.toString();
			result.add(s);
			return;
		}

		if(left<0||right<0||left>right){
			return;
		}

		if(left>0){
			sb.append('(');
			helper(result, left-1, right, sb);
			sb.deleteCharAt(sb.length()-1);
		}
		//try right
		if(right>left){
			sb.append(')');
			helper(result, left, right-1, sb);
			sb.deleteCharAt(sb.length()-1);
		}

	}
}
