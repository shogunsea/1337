// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.
public class Solution {
    public boolean isPalindrome(String s) {
    	// int len = s.length();
    	// if(len<2){
    	// 	return true;
    	// }
    	// Stack<Character> st = new Stack<Character>();
    	StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
			int c = s.charAt(i);
			if(alphanumeric(c)){
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
		}
		String ss = sb.toString();
		int len = ss.length();
		if(len<2){
			return true;
		}
		int i = 0;
		int j = len-1;
		while(i<j){
			if(ss.charAt(i)!=ss.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
    }

    public boolean alphanumeric(int c){
    	boolean num = (c>=48&&c<=57);
    	boolean upper = (c>=65&&c<=90);
    	boolean lower = (c>=97&&c<=122);
    	return num||upper||lower;
    }
}