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
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        char[] tChars = T.toCharArray();
        char[] sChars = S.toCharArray();
        for(char c : tChars){
        	dict.put(c, dict.containsKey(c)? dict.get(c)+1: 1);
        	found.put(c, 0);
        }
        int minStart = -1, minEnd = sLen, start = 0, end =0, count = 0;
        for(; end<sLen; end++){
        	char c = sChars[end];
        	if(dict.containsKey(c)){
        		found.put(c, found.get(c)+1);

        		// increase to get the first window, then won't be
        		// executed.
        		if(found.get(c)<=dict.get(c)){
	        		count++;
	        	}

	        	if(count==tLen){
	        		while(!dict.containsKey(sChars[start])||found.get(sChars[start])>dict.get(sChars[start])){
	        			if(dict.containsKey(sChars[start])){
	        				if(found.get(sChars[start])>dict.get(sChars[start])){
	        					found.put(sChars[start], found.get(sChars[start])-1);
	        				}
	        			}
	        			start++;
	        		}
	        		if(end - start < minEnd - minStart ){
	        			minEnd = end;
	        			minStart = start;
	        		}
	        	}
        	}
        }
        return minStart==-1? "" : S.substring(minStart, minEnd+1);
    }
}