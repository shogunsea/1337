// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] A) {
    	int len = A.length;

    	if(len==0){
    		return 1;
    	}

    	int[] dp = new int[len+1];

    	for(int i = 0; i<len; i++){
    		if(A[i]>0&&A[i]<=len){
    			dp[A[i]] = 1; 
    		}
    	}

    	int miss = 1;
    	for(int i = 1; i<=len; i++){
    		if(A[i]!=1&&A[i]!=len){
    			miss = i;
    			break;
    		}else if(A[i]==len){
    			miss = i+1;
    			break;
    		}
    	}

    	return miss;

    }
}