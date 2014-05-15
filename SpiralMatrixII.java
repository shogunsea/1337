// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        if(n==0){
            return matrix;
        }
        
        int xMin = 0;
        int xMax = n -1;
        int yMin = 0;
        int yMax = n - 1;
        int counter = 0;
        int x = 0, y = 0;
        matrix[y][x] = ++counter;

        while(true){

        	while(x < xMax){
        		x++;
        		matrix[y][x] = ++counter;
        	}

        	yMin++;

        	if(yMin > yMax){
        		break;
        	}

        	while(y < yMax){
        		y++;
        		matrix[y][x] = ++counter;
        	}

        	xMax--;

        	if(xMin > xMax){
        		break;
        	}

        	while(x > xMin){
        		x--;
        		matrix[y][x] = ++counter;
        	}

        	yMax--;

        	if(yMin > yMax){
        		break;
        	}

        	while(y > yMin){
        		y--;
        		matrix[y][x] = ++counter;
        	}

        	xMin++;

        	if(xMin > xMax){
        		break;
        	}
        }
        return matrix;
    }
}