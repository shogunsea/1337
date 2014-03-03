// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

public class Solution {
       public  ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> result = new ArrayList<String>();
    	int len = digits.length();
    	if(len==0){
    	    result.add("");
    		return result;
    	}

    	String[] board = {" ", "1", "abc", "def", "ghi","jkl", "mno", "pqrs","tuv", "wxyz"};
		StringBuilder sb = new StringBuilder();
		helper(digits, len, sb, board, 0, result);

		return result;        
    }

    public  void helper(String digits, int len, StringBuilder sb, String[] board, int index, ArrayList<String> result){
    	if(sb.length()==len){
    		String tempString = sb.toString();
    		result.add(tempString);
    		sb = new StringBuilder();
    		return;
    	}
    	if(index>len-1){
    		return;
    	}

    	int digit = digits.charAt(index) - '0';

    	String letters = board[digit];

    	for(int i = 0; i<letters.length(); i++){
    		char tempChar = letters.charAt(i);
    		sb.append(tempChar);
    		helper(digits, len, sb, board, index+1, result);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
}