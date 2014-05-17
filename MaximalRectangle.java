// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

public class Solution {
    public int maximalRectangle(char[][] matrix) {
 		int row = matrix.length;

 		if(row==0){
 			return 0;
 		}

 		if(row%2==0){

 		int col = matrix[0].length;
 		int[][] dp = new int[row][col];

 		for(int i = 0; i < row; i++){
 			dp[i][0] = matrix[i][0] == '1'? 1 : 0;
 		}

 		for(int i = 0; i < row; i++){
 			for(int j = 1; j < col; j++){
 				dp[i][j] = matrix[i][j] == '1'? dp[i][j-1] + 1 : 0;
 			}
 		}

 		int area = 0;
 		int width, height;
 		for(int i = 0; i < row; i++){
 			for(int j = 0; j < col; j++){
 				int k = i;
 				width = Integer.MAX_VALUE;

 				while(k >= 0){
 					if(dp[k][j] == 0){
 						break;
 					}

 					width = Math.min(width, dp[k][j]);
 					height = i - k + 1;
 					area = Math.max(area, width * height);
 					k--;
 				}

 			}
 		}

 		return area;
 		}else{
 		int col = matrix[0].length;
 		int[][] dp = new int[row][col];

 		for(int i = 0; i < col; i++){
 			dp[0][i] = matrix[0][i] == '1'? 1 : 0;
 		}

 		for(int j = 0; j < col; j++){
 			for(int i = 1; i < row; i++){
 				dp[i][j] = matrix[i][j] == '1'? dp[i-1][j] + 1 : 0;
 			}
 		}

 		int area = 0;
 		int height, width;

 		for(int j = 0; j < col; j++){
 			for(int i = 0; i < row; i++){
 				int k = j;
 				height = Integer.MAX_VALUE;
 				
 				while(k >= 0){
 					if(dp[i][k] == 0){
 						break;
 					}

	 				height = Math.min(height, dp[i][k]);
	 				width = j - k + 1;
	 				area = Math.max(area, height * width);
	 				k--;
 				}
 			}
 		}

 		return area;
 		}
 	}
 }
