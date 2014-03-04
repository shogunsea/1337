// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?

public class Solution{
    public void rotate(int[][] image){
        int n = image.length;
        
        for(int layer = 0; layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i< last; i++){
                int offset = i- first;
                int leftTop = image[first][i];
                
                // left corner to left top;
                image[first][i] = image[last-offset][first];
                // right corner to left corner
                image[last-offset][first] = image[last][last-offset];
                // right top to right corner
                image[last][last-offset] = image[i][last];
                // left top to right top
                image[i][last] = leftTop;
        
            }

        }   
    }
}