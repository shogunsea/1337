// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].
public class Solution{
    public ArrayList<String> wordBreak(String s, Set<String> dict){
        ArrayList<String> result = new ArrayList<String>();
        int len = s.length();
        boolean[] splitPoint = new boolean[len+1];
        splitPoint[0] = true;
        
        for(int i = 1; i<len+1; i++){
            for(int j = 0; j<i; j++){
                String tempString = s.substring(j, i);
                if(splitPoint[j]&&dict.contains(tempString)){
                    splitPoint[i] = true;
                    break;
                }
            }
        } 
        if(splitPoint[len]==false){
            return result;
        }
        
        
        
        
        StringBuilder sb = new StringBuilder();
        helper(s, result, sb, 0, dict);
        return result;           
    }
    
    public void helper(String s, ArrayList<String> result, StringBuilder sb, int index, Set<String> dict){
        if(index==s.length()){
            String tempString = sb.toString();
            sb = new StringBuilder();
            result.add(tempString);
            return;
        }       
        for(int i = index+1; i<s.length()+1; i++){
            String tempString = s.substring(index, i);
            if(dict.contains(tempString)){
                int currentLength = sb.length();
                if(currentLength!=0){
                    sb.append(" ");
                }
                sb.append(tempString);
                helper(s, result, sb, i, dict);
                sb.delete(currentLength, sb.length());           
            }        
        }
            
   }
}