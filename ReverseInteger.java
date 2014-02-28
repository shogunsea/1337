// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

public class Solution {
   public int reverse(int x) {
   	 boolean pos = x>0;

   	 int abs = Math.abs(x);

   	 int temp = abs;
   	 int result = 0

   	 while(temp>0){
   	 	int remain = temp%10;
   	 	result = result*10 + remain;
   	 	temp = temp/10;
   	 }

   	 if(pos){
   	 	return result;
   	 }else{
   	 	return result*(-1);
   	 }

   }
}
