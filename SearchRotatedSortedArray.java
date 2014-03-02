// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] A, int target) {
        int len = A.length;
        if(len<1){
        	return 0;
        }

        int left = 0;
        int right = len-1;

        while(left<=right){
        	int mid = left + ((right-left)>>1);

        	if(A[mid]==target){
        		return mid;
        	}
        	// left half is sorted
        	if(A[left]<=A[mid]){
        		if(A[left]<=target&&target<A[mid]){
        			right = mid-1;
        		}else{ // pivot is in the right half.
        			left = mid+1;
        		}
        	}else{
        		if(A[right]>=target&&A[mid]<target){
        			left = mid+1;
        		}else{ //  pivot is in the left half.
        			right = mid -1;
        		}
        	}
        }
        return -1;
    }
}