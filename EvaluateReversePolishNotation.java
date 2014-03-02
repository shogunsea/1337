// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class Solution {
    public int evalRPN(String[] tokens){
    	Stack<Integer> stack = new Stack<Integer>();

    	for(String s:tokens){
    		try{
    			stack.push(Integer.parseInt(s));
    		}catch(Exception e){
    			int right = stack.pop();
    			int left = stack.pop();

    			stack.push(calc(left, right, s));
    		}
    	}
    	return stack.pop();
    }

    public int calc(int left, int right, String operator){
    	int result = 0;
    	if(operator.equals("+")){
    		result = left + right;
    	}else if (operator.equals("-")){
    		result = left - right;
    	}else if (operator.equals("*")){
    		result =  left * right;
    	}else{
    		result = left / right ;
    	}
    	return result;
    }
}