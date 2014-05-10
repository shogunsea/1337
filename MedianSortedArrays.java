public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	int aLen = A.length;
		int bLen = B.length;
		int len = aLen + bLen;
		boolean odd = len%2==0? false : true;
		int[] combine = new int[len/2 + 1];
		int pA = 0;
		int pB = 0;

		for(int i = 0; i<combine.length; i++){
			if(pA<aLen&&pB<bLen){
				// compare and continue
				if(A[pA]<B[pB]){
					combine[i] = A[pA];
					pA++;
				}else{
					combine[i] = B[pB];
					pB++;
				}
				continue;
			}
			if(pA<aLen){
				combine[i] = A[pA];
			}
			if(pB<bLen){
				combine[i] = B[pB];
			}

		}

		double result = 0;
		if(odd){
			result = combine[combine.length-1];
		}else{
			int last = combine.length-1;
			result = (combine[last] + combine[last-1])/2.0;
		}
		return result;

	}
}



