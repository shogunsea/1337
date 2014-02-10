// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class Solution {
    public int evalRPN(String[] tokens) {
    	if(tokens.length==0) return 0;
    	Stack<Integer> list = new Stack<Integer>();

    	for(String s: tokens){
    		try{
    			int value = Integer.parseInt(s);
    			list.push(value);
    		}catch(Exception e){
    			int right = list.pop();
    			int left = list.pop();
    			list.push(calc(left, right, s));
    		}
    	}

    	return list.pop();
    }

    public int calc(int left, int right, String operand){
    	int result = 0;

    	if(operand.equals("+")){
    		result = left + right;
    	}else if(operand.equals("-")){
    		result = left - right;
    	}else if(operand.equals("*")){
    		result = left * right;
    	}else{
    		result = left / right;
    	}

    	return result;
    }
}