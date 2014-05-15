// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note: The numbers can be arbitrarily large and are non-negative.

public class Solution {
    public String multiply(String num1, String num2) {
    	if( num1 == null || num2 == null ){
    		return null;
    	}

    	int len1 = num1.length();
    	int len2 = num2.length();
    	int len3 = len1 + len2;
    	int[] num = new int[len3];

    	for(int i = len1 -1; i>=0; i--){
    		int carry = 0;
    		int product = 0;
    		int j = len2-1;

    		for(; j>=0; j--){
    			int i1 = num1.charAt(i) - '0';
    			int i2 = num2.charAt(j) - '0';
    			product = carry + num[i+j+1] + i2*i1;
    			num[i+j+1] = product % 10;
    			carry = product / 10;
    		}
    		num[i+j+1] = carry;
    	}

    	StringBuffer sb = new StringBuffer();

    	for(int i = 0; i<len3; i++){
    		if(num[i]!=0){
    			for(int j = i; j<len3; j++){
    				sb.append(num[j]);
    			}
    			break;
    		}
    		if(i==len3-1){
    		    // if all zero and reached the last element.
    		    sb.append(0);
    		}
    	}

    	return sb.toString();
    }
}