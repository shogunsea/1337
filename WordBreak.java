// Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

public class Solution{
    public boolean wordBreak(String s, Set<String> dict){
         int len = s.length();
         boolean[] splitPoint = new boolean[len+1];
         splitPoint[0] = true;
         
         for(int i = 1; i<=len; i++){
             for(int j = 0; j<i; j++){
                 String temp = s.substring(j,i);
                 if(splitPoint[j]&&dict.contains(temp)){
                     splitPoint[i] = true;
                     break;
                 }
             }
         }
         
         return splitPoint[len];
         
     
        
    }
}