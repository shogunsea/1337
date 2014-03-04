// Given two binary strings, return their sum (also a binary string).
// For example,
// a = "11"
// b = "1"
// Return "100".


// add 
public class Solution {
     public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen==0){
            return b;
        }else if(bLen==0){
            return a;
        }

        // move to the last char index.
        aLen--;
        bLen--;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(aLen>=0||bLen>=0||carry>0){
            int numA, numB;
            if(aLen>=0){
                numA = a.charAt(aLen)-'0';
                aLen--;
            }else{
                numA = 0;
            }

            if(bLen>=0){
                numB = b.charAt(bLen)-'0';
                bLen--;
            }else{
                numB = 0;
            }
            int sum = (numA+numB+carry)%2;
            carry = (numA+numB+carry)/2;
            sb.insert(0,sum);
        }
        return sb.toString();
     }
 }

// Own version.
// public class Solution{
//     public String addBinary(String a, String b){
//         int aLen = a.length();
//         int bLen = b.length();
//         if(aLen==0){
//             return b;
//         }else if(bLen==0){
//             return a;
//         }
        
//         aLen--;
//         bLen--;      
//         StringBuilder sb = new StringBuilder();
//         int sum = 0;
//         int carry = 0;
        
//         while(aLen>=0||bLen>=0){
//             sum = 0;
//             if(aLen>=0){
//                 sum+=a.charAt(aLen)-'0';
//                 aLen--;
//             }
//             if(bLen>=0){
//                 sum+=b.charAt(bLen)-'0';
//                 bLen--;
//             }
//             sum+=carry;
//             carry = sum/2;
//             sb.insert(0, sum%2);
//         }
//         if(carry!=0){
//             sb.insert(0,1);
//         }
        
//         return sb.toString();
    
//     }

// }