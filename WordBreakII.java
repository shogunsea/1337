// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].


public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(s.length()==0){
    		return result;
    	}
    	int length = s.length();
    	boolean[] splitPoint = new boolean[length+1];
    	splitPoint[0] = true;
    	for(int i = 1; i<length+1; i++){
    		for(int j=0;j<i;j++){
    			String tempString = s.substring(j,i);
    			if(splitPoint[j]&&dict.contains(tempString)){
    				splitPoint[i] = true;
    				break;
    			}
    		}
    	}
    	if(splitPoint[length]==false){
    		return result;
    	}
    	StringBuilder sb = new StringBuilder();
    	helper(s, 0, sb, result, dict);
    	return result;
    }

    public void helper(String s, int start, StringBuilder sb, ArrayList<String> result, Set<String> dict){
    	if(start>=s.length()){
    		String tempString = new String(sb);
    		result.add(tempString);
    		return;
    	}
    	for(int i = start+1; i<=s.length(); i++){
    		String tempString = s.substring(start, i);
    		if(dict.contains(tempString)){
    			int oldLen = sb.length();
    			if(oldLen!=0){
    				sb.append(" ");
    			}
    			sb.append(tempString);
    			helper(s, i, sb, result, dict);
    			sb.delete(oldLen, sb.length());
    		}
    	}
    }
}