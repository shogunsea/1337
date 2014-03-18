// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
 		       int len = s.length();
 		       ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
 		       if(len<1){
 		       		return result;
 		       }
 		       ArrayList<String> tempList = new ArrayList<String>();
 		       helper(result, tempList, s, 0);
 		       return result;
    }

    public void helper(ArrayList<ArrayList<String>> result, ArrayList<String> tempList, String s, int index){
    	if(index==s.length()){
    		result.add(new ArrayList<String>(tempList));
    		return;
    	}

    	for(int i = index; i<s.length(); i++){
    		if(isPalin(s, index, i)){
    			String tempString = s.substring(index, i+1);
	    		tempList.add(tempString);
	    		helper(result, tempList, s, i+1);
	    		tempList.remove(tempList.size()-1);	
    		}
    	}
    }

    public boolean isPalin(String s, int start, int end){
    	while(start<=end){
    		if(s.charAt(start)!=s.charAt(end)){
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
}