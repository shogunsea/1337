// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len==0){
        	return true;
        }

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for(int i = 0; i<len; i++){
        	char tempChar = s.charAt(i);
        	if(tempChar=='('||tempChar=='['||tempChar=='{'){
        		stack.push(tempChar);
        	}else if(stack.isEmpty()||tempChar!=map.get(stack.pop())){
        		return false;
        	}
        }

        if(stack.isEmpty()){
        	return true;
        }
        return false;
    }
}