// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if(len<1){
        	return s;
        }

        Stack<String> st = new Stack<String>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<len; i++){
        	if(s.charAt(i)==' '&&sb.length()!=0){
        		String temp = sb.toString();
        		sb = new StringBuilder();
        		st.push(temp);
        	}else if(s.charAt(i)==' '&&sb.length()==0){
        		continue;
        	}else{
        		sb.append(s.charAt(i));
        	}
        }

        if(sb.length()!=0){
        	String last = sb.toString();
        	st.push(last);
        }

        sb = new StringBuilder();
        int size = st.size();
        for(int i = 0; i<size; i++){
        	if(i==size-1){
        		sb.append(st.pop());
        		break;
        	}
        	sb.append(st.pop()+" ");
        }

        return sb.toString();
    }
}