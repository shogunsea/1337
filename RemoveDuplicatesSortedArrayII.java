public class Solution {
 public int removeDuplicates(int[] A) {
 	// the idea is that, it's similar to question I which removes the elements that
 	// show up twice, here we remove elements that show up more than twice, we can use a 
 	// variable to count how many times the variable has shown up, by comparing current element
 	// with previous one, if they are different just reset counting variable to one, if not,first check
 	// the value of counting variable, if it's two then we found the third occurence of same element
 	// we need to remove it. To do this, we only increase fast index and continue the loop. At each loop
 	// we copy value of fast index to slow index then increase both indexes.
 	if(A.length<=1) return A.length;
 	int slow = 1;
 	int count = 1;
 	for(int fast = 1;fast<A.length;){
 		if(A[fast] == A[fast-1]){
 			if(count==2){
 				fast++;
 				continue;
 			}else{
 				count++;
 			}
 		}else{
 			count=1;
 		}
 		A[slow] = A[fast];
 		slow++;
 		fast++;
 	}
 	return slow;
 }
}