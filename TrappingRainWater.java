// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len<=2){
        	return 0;
        }

        int[] leftHeight = new int[len];
        leftHeight[0] = A[0];
        int max = A[0];
        for(int i = 1; i<len; i++){
        	leftHeight[i] = max;
        	if(A[i]>max){
        		max = A[i];
        	}
        }

        int water = 0;
        max = A[len-1];

        for(int i = len-2; i>0; i--){
        	int left = leftHeight[i];
        	int right = max;
        	int container = Math.min(left, right);
        	if(container>=A[i]){
        		water+= container-A[i];
        	}
        	if(max<A[i]){
        		max = A[i];
        	}
        }
        return water;
    }
}