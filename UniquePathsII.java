// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// Note: m and n will be at most 100.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if(row==0 || col==0){
        	return 0;
        }

        // mark the obstacles.
        for(int i = 0; i<row; i++){
        	for(int j = 0; j<col; j++){
        		if(obstacleGrid[i][j]==1){
        			obstacleGrid[i][j] = -1;
        		}
        	}
        }

        for(int i =0; i<row; i++){
        	if(obstacleGrid[i][0]==-1){
        		break;
        	}
        	obstacleGrid[i][0] = 1;
        }
        for(int j = 0; j<col; j++){
        	if(obstacleGrid[0][j]==-1){
        		break;
        	}
        	obstacleGrid[0][j] = 1;
        }

        for(int i = 1; i<row; i++){
        	for(int j = 1; j<col; j++){
        		int top = obstacleGrid[i-1][j]==-1? 0 : obstacleGrid[i-1][j];
        		int left = obstacleGrid[i][j-1]==-1? 0: obstacleGrid[i][j-1];
        		obstacleGrid[i][j] = obstacleGrid[i][j]==-1? -1 : (top + left);
        	}
        }

        return obstacleGrid[row-1][col-1]==-1? 0: obstacleGrid[row-1][col-1];
    }
}