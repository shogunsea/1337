// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// If there is no such window in S that covers all characters in T, return the emtpy string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    public String minWindow(String S, String T) {
    	int sLen = S.length();
		int tLen = T.length();
        if(tLen==0 || sLen==0){
        	return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] tChars = T.toCharArray();
        char[] sChars = S.toCharArray();
        for(char c : tChars){
        	map.put(c, map.containsKey(c)? map.get(c)+1: 1);
        }
        
        for(int i = 0; i<-len; i++){

        }
}
}