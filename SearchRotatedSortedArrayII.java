// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?

// Write a function to determine if a given target is in the array.

public class Solution {
    public boolean search(int[] A, int target) {
    	int len = A.length;
        if(len<1){
        	return false;
        }

        int left = 0;
        int right = len-1;

        while(left<=right){
        	int mid = left + ((right-left)>>1);

        	if(A[mid]==target){
        		return true;
        	}
        	// left half is sorted
        	if(A[left]<A[mid]){
        		if(A[left]<=target&&target<A[mid]){
        			right = mid-1;
        		}else{ // pivot is in the right half.
        			left = mid+1;
        		}
        	}else if(A[left]>A[mid]){
        		if(A[right]>=target&&A[mid]<target){
        			left = mid+1;
        		}else{ //  pivot is in the left half.
        			right = mid -1;
        		}
        	}else{
        		left++;
        	}
        }
        return false;
    }
}