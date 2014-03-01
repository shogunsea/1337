// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?

public class Solution {
    public void rotate(int[][] matrix) {
       if(matrix.length<1){
       		return;
       }

       int n = matrix.length;

       for(int layer = 0; layer<n/2; layer++){
       		int first = layer;
       		int last = n-1-layer;
       		for(int i = first; i<last; i++){
       			int offset = i - first;
       			int top = matrix[first][i];

       			matrix[first][i] = matrix[last-offset][first];

       			matrix[last-offset][first] = matrix[last][last-offset];

       			matrix[last][last-offset] = matrix[i][last];

       			matrix[i][last] = top;
       		}
       }
   }
}
