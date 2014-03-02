// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Recursion, TLE
// public class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         if(m==0){
//         	return m;
//         }
//         int n = grid[0].length;

//         int[] min = {Integer.MAX_VALUE};

//         helper(0,0,grid,min,0);

//         return min[0];
//     }

//     public void helper(int m, int n, int[][] grid, int[] min, int cost){
//     	if(m>grid.length-1||n>grid[0].length-1){
//     		return;
//     	}

//     	int temp = cost + grid[m][n];

//     	if(m==grid.length-1&&n==grid[0].length-1){
//     		min[0] = temp;
//     		return;
//     	}
//     	if(temp<min[0]){
//     		helper(m+1,n,grid,min,temp);
//     		helper(m,n+1,grid,min,temp);
//     	}else{
//     		return;
//     	}
//     }
// }
public class Solution {
    public int minPathSum(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
    	int[][] cost = new int[row][col];

    	cost[0][0] = grid[0][0];
    	for(int i = 1; i<row; i++){
    		cost[i][0] = cost[i-1][0]+ grid[i][0];
    	} 
    	for(int j = 1; j<col; j++){
    		cost[0][j] = cost[0][j-1] + grid[0][j];
    	}

    	for(int i = 1; i<row; i++){
    		for(int j = 1; j<col; j++){
    			cost[i][j] = grid[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
    		}
    	}

    	return cost[row-1][col-1];
    }
}