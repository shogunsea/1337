// need to try dp approach

public class Solution {
    public boolean isScramble(String s1, String s2) {
    	int l1 = s1.length();
    	int l2 = s2.length();
    	if(l1!=l2){
    		return false;
    	}
    	// assume chars from a-z
    	int[] count = new int[26];
    	for(int i = 0; i<l1; i++){
    		count[s1.charAt(i)-'a']++;
    	}
    	for(int i =0; i<l2; i++){
    		count[s2.charAt(i)-'a']--;
    	}
    	for(int i =0; i<26; i++){
    		if(count[i]!=0){
    			return false;
    		}
    	}

    	if(l1==1){
    		return true;
    	}

    	for(int i = 1; i<l1; i++){
    		boolean same_side = isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i));
    		if(same_side){
    			return true;
    		}
    		boolean cross_side = isScramble(s1.substring(0,i), s2.substring(l1-i))&&isScramble(s1.substring(i), s2.substring(0,l1-i));
    		if(cross_side){
    			return true;
    		}
    	}
    	return false;
    }
}