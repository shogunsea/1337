// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Two pass solution.
// public class Solution {
//     public void sortColors(int[] A) {
//         if(A.length==0){
//         	return;
//         }
//         int len = A.length;
//         int zero = 0;
//         int one = 0;
//         int two = 0;
//         for(int i = 0; i<len; i++){
//         	if(A[i]==0){
//         		zero++;
//         	}else if(A[i]==1){
//         		one++;
//         	}else{
//         		two++;
//         	}
//         }
//         for(int i=0; i<len; i++){
//         	if(zero>0){
//         		A[i] = 0;
//         		zero--;
//         		continue;
//         	}
//         	if(one>0){
//         		A[i] = 1;
//         		one--;
//         		continue;
//         	}
//         	if(two>0){
//         		A[i] = 2;
//         		two--;
//         		continue;
//         	}
//         }

//     }
// }

// One pass solution.
public class Solution {
    public void sortColors(int[] A) {
    	if(A.length==0){
    		return;
    	}

    	int len = A.length;
    	int zero = 0;
    	int two = len-1;

    	for(int i = 0; i<=two; i++){
    		if(A[i]==0){
    			int p = A[i];
    			A[i] = A[zero];
    			A[zero] = p;
    			zero++;
    			continue;
    		}
    		if(A[i]==1){
    			continue;
    		}
    		if(A[i]==2){
    			int p = A[i];
    			A[i] = A[two];
    			A[two] = p;
    			two--;
    			i--;
    			continue;
    		}

    	}
    }
}