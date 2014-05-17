// Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    // public String longestCommonPrefix(String[] strs) {
    // 	if(strs.length==0){
    // 		return "";
    // 	}

    // 	ArrayList<Character> list = new ArrayList<Character>();
    // 	int index = 0;
    // 	int num = strs.length;

    // 	while(true){
    // 		if(index >= strs[0].length()){
    // 			break;
    // 		}

    // 		char c = strs[0].charAt(index);
    // 		int match = 0;

    // 		for(int i = 1; i<num; i++){
    // 			if(index >= strs[i].length() || strs[i].charAt(index)!=c){
    // 				break;
    // 			}
    // 			match++;
    // 		}
    // 		if(match!=num-1){
    // 			break;
    // 		}

    // 		index++;
    // 	}

    // 	return strs[0].substring(0, index);
    // }
    public String longestCommonPrefix(String[] strings){
    	int len = strings.length;

    	if(len==0){
    		return "";
    	}

    	String temp = strings[0];

    	for(int i = 1; i<len; i++){
			int j = 0;
			
			while(j<strings[i].length() && j<temp.length() && temp.charAt(j) == strings[i].charAt(j)){
				j++;
			}

			if(j==0){
				return "";
			}

			temp = temp.substring(0, j);
		}

		return temp;
    }
}




