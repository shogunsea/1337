// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
        matched[0][0] = true;
        for(int i1 = 1; i1 <= s1.length(); i1++){
            if(s3.charAt(i1-1) == s1.charAt(i1-1)) {
                matched[i1][0] = true;
            }else break;
        }
        for(int i2 = 1; i2 <= s2.length(); i2++){
            if(s3.charAt(i2 - 1) == s2.charAt(i2 - 1)) {
                matched[0][i2] = true;
            }else break;
        }
        
        for(int i2 = 1; i2 <= s2.length(); i2++){
            char c2 = s2.charAt(i2 - 1);
            for(int i1 = 1; i1 <= s1.length(); i1++){
                int i3 = i1 + i2;
                char c1 = s1.charAt(i1 - 1);
                char c3 = s3.charAt(i3 - 1);
                boolean from_s1 = (s1.charAt(i1-1)==s3.charAt(i3-1))&&matched[i1-1][i2];
                boolean from_s2 = (s2.charAt(i2-1)==s3.charAt(i3-1))&&matched[i1][i2-1];
                matched[i1][i2] = from_s1 || from_s2;
                //((s1.charAt(i1-1)==s3.charAt(i3-1))&&matched[i1-1][i2]) || ((s2.charAt(i2-1)==s3.charAt(i3-1)&&matched[i1][i2-1]));
// s1[l1-1] == s3[l1+l2-1] && matched[l1-1][l2] || s2[l2 - 1] == s3[l1+l2-1] && matched[l1][l2-1]
//                 if(c1 == c3){
//                     matched[i1][i2] |= matched[i1 - 1][i2];
//                 }
//                 if(c2 == c3){
//                     matched[i1][i2] |= matched[i1][i2 - 1];
//                 }
            }
        }


        return matched[s1.length()][s2.length()];
    }
}