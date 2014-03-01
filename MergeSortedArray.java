// Given two sorted integer arrays A and B, merge B into A as one sorted array.

// Note:
// You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    	if(n==0){
    		return;
    	}else if(m==0){
    		for(int i = 0; i<B.length; i++){
    			A[i] = B[i];
    		}
    		return;
    	}
		int len = m+n-1;
		int i = m-1; 
		int j = n-1;
		while(i>=0&&j>=0){
			if(A[i]>B[j]){
				A[len] = A[i];
				i--;
			}else{
				A[len] = B[j];
				j--;
			}
			len--;
		}
		
		while(j>=0){
			A[len] = B[j];
			len--;
			j--;
		}
    }
}